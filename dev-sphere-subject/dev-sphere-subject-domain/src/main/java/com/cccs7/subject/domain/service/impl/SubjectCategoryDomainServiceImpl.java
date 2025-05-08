package com.cccs7.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.cccs7.subject.common.enums.IsDeletedFlagEnum;
import com.cccs7.subject.domain.convert.SubjectCategoryConverter;
import com.cccs7.subject.domain.entity.SubjectCategoryBO;
import com.cccs7.subject.domain.entity.SubjectLabelBO;
import com.cccs7.subject.domain.service.SubjectCategoryDomainService;
import com.cccs7.subject.infra.basic.entity.SubjectCategory;
import com.cccs7.subject.infra.basic.entity.SubjectLabel;
import com.cccs7.subject.infra.basic.entity.SubjectMapping;
import com.cccs7.subject.infra.basic.service.SubjectCategoryService;
import com.cccs7.subject.infra.basic.service.SubjectLabelService;
import com.cccs7.subject.infra.basic.service.SubjectMappingService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {


    @Resource
    private SubjectCategoryService subjectCategoryService;

    @Resource
    private SubjectLabelService subjectLabelService;
    @Resource
    private SubjectMappingService subjectMappingService;

    @Resource
    private ThreadPoolExecutor labelThreadPool;

    @Override
    public void add(SubjectCategoryBO subjectCategoryBO) {

        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryController.add.bo: {}", subjectCategoryBO);
        }

        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.bo2po(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectCategoryService.insert(subjectCategory);
    }

    @Override
    public Boolean update(SubjectCategoryBO subjectCategoryBO) {

        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryController.update.bo: {}", subjectCategoryBO);
        }

        try {
            SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.bo2po(subjectCategoryBO);
            subjectCategoryService.update(subjectCategory);
            return true;
        } catch (Exception e) {
            log.error("SubjectCategoryDomainService.update.bo.error:{}", subjectCategoryBO);
            return false;
        }
    }


    @Override
    public List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO) {


        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.bo2po(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryCategory(subjectCategory);
        List<SubjectCategoryBO> subjectCategoryBOList = SubjectCategoryConverter.INSTANCE.pos2bos(subjectCategoryList);

        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryController.queryPrimaryCategory.boList:{}",
                    JSON.toJSONString(subjectCategoryBOList));
        }

        subjectCategoryBOList.forEach(bo -> {
            Integer subjectCount = subjectCategoryService.querySubjectCount(bo.getId());
            bo.setCount(subjectCount);
        });
        return subjectCategoryBOList;
    }


    /**
     * 删除分类  -  逻辑删除
     *
     * @param subjectCategoryBO 主题类别bo
     * @return {@link Boolean }
     */
    @Override
    public Boolean delete(SubjectCategoryBO subjectCategoryBO) {

        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE.bo2po(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        int update = subjectCategoryService.update(subjectCategory);
        return update > 0;
    }

    @SneakyThrows
    @Override
    public List<SubjectCategoryBO> queryCategoryAndLabel(SubjectCategoryBO subjectCategoryBO) {
        //查询当前大类下所有分类
        SubjectCategory subjectCategory = new SubjectCategory();
        subjectCategory.setParentId(subjectCategoryBO.getId());
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryCategory(subjectCategory);
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryController.queryCategoryAndLabel.subjectCategoryList:{}",
                    JSON.toJSONString(subjectCategoryList));
        }
        List<SubjectCategoryBO> categoryBOList = SubjectCategoryConverter.INSTANCE.pos2bos(subjectCategoryList);

        HashMap<Long, List<SubjectLabelBO>> map = new HashMap<>();
        List<CompletableFuture<Map<Long, List<SubjectLabelBO>>>> completableFutureList
                = categoryBOList.stream().map((category) ->
                CompletableFuture.supplyAsync(() -> getLabelBoList(category), labelThreadPool)
        ).collect(Collectors.toList());
        
        // 并发获取结果
        completableFutureList.forEach( future -> {
            try {
                Map<Long, List<SubjectLabelBO>> resultMap = future.get();
                map.putAll(resultMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
        // 组装数据
        categoryBOList.forEach(categoryBO -> {
            categoryBO.setLabelBOList(map.get(categoryBO.getId()));
        });
        return categoryBOList;
    }

    private Map<Long, List<SubjectLabelBO>> getLabelBoList(SubjectCategoryBO category) {
        Map<Long, List<SubjectLabelBO>> labelMap = new HashMap<>();
        
        // 查询分类-标签映射关系
        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setCategoryId(category.getId());
        List<SubjectMapping> mappingList = subjectMappingService.queryLabelId(subjectMapping);
        if (CollectionUtils.isEmpty(mappingList)) {
            return null;
        }
        
        // 提取标签ID并批量查询标签信息
        List<Long> labelIdList = mappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
        List<SubjectLabel> labelList = subjectLabelService.batchQueryById(labelIdList);
        
        // 转换为BO对象
        List<SubjectLabelBO> labelBOList = new LinkedList<>();
        labelList.forEach(label -> {
            SubjectLabelBO subjectLabelBO = new SubjectLabelBO();
            subjectLabelBO.setId(label.getId());
            subjectLabelBO.setLabelName(label.getLabelName());
            subjectLabelBO.setCategoryId(Long.valueOf(label.getCategoryId()));
            subjectLabelBO.setSortNum(label.getSortNum());
            labelBOList.add(subjectLabelBO);
        });
        
        // 建立分类ID与标签列表的映射
        labelMap.put(category.getId(), labelBOList);
        return labelMap;
    }
}


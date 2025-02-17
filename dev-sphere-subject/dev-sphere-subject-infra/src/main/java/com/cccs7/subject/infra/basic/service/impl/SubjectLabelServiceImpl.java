package com.cccs7.subject.infra.basic.service.impl;

import com.cccs7.subject.common.enums.IsDeletedFlagEnum;
import com.cccs7.subject.infra.basic.entity.SubjectLabel;
import com.cccs7.subject.infra.basic.mapper.SubjectLabelDao;
import com.cccs7.subject.infra.basic.service.SubjectLabelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 题目标签表(SubjectLabel)表服务实现类
 *
 * @author makejava
 * @since 2025-01-01 23:12:00
 */
@Service("subjectLabelService")
public class SubjectLabelServiceImpl implements SubjectLabelService {
    @Resource
    private SubjectLabelDao subjectLabelDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectLabel queryById(Long id) {
        return this.subjectLabelDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param subjectLabel 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectLabel insert(SubjectLabel subjectLabel) {
        this.subjectLabelDao.insert(subjectLabel);
        return subjectLabel;
    }

    /**
     * 修改数据
     *
     * @param subjectLabel 实例对象
     * @return 实例对象
     */
    @Override
    public int update(SubjectLabel subjectLabel) {
        return this.subjectLabelDao.update(subjectLabel);

    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectLabelDao.deleteById(id) > 0;
    }


    /**
     * 逻辑删除
     *
     * @param subjectLabel 主题标签
     * @return int
     */
    @Override
    public int delete(SubjectLabel subjectLabel) {

        subjectLabel.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        return this.subjectLabelDao.update(subjectLabel);

    }

    /**
     * 通过分类id查询标签
     *
     * @param subjectLabel 题目标签
     * @return {@link List }<{@link SubjectLabel }>
     */
    @Override
    public List<SubjectLabel> queryLabelByCategoryId(SubjectLabel subjectLabel) {
        return subjectLabelDao.queryLabelByCategoryId(subjectLabel);
    }

    /**
     * 按id批量查询
     *
     * @param labelIdList 标签id列表
     * @return {@link List }<{@link SubjectLabel }>
     */
    @Override
    public List<SubjectLabel> batchQueryById(List<Long> labelIdList) {
        return this.subjectLabelDao.batchQueryById(labelIdList);
    }
}

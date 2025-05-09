package com.cccs7.subject.infra.basic.service.impl;

import com.cccs7.subject.infra.basic.entity.SubjectInfo;
import com.cccs7.subject.infra.basic.mapper.SubjectInfoDao;
import com.cccs7.subject.infra.basic.service.SubjectInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * 题目信息表(SubjectInfo)表服务实现类
 *
 * @author makejava
 * @since 2025-01-01 23:11:17
 */
@Service("subjectInfoService")
public class SubjectInfoServiceImpl implements SubjectInfoService {
    @Resource
    private SubjectInfoDao subjectInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectInfo queryById(Long id) {
        return this.subjectInfoDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param subjectInfo 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectInfo insert(SubjectInfo subjectInfo) {
        this.subjectInfoDao.insert(subjectInfo);
        return subjectInfo;
    }

    /**
     * 修改数据
     *
     * @param subjectInfo 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectInfo update(SubjectInfo subjectInfo) {
        this.subjectInfoDao.update(subjectInfo);
        return this.queryById(subjectInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectInfoDao.deleteById(id) > 0;
    }

    /**
     * 按条件查询
     *
     * @param subjectInfo 题目信息
     * @param labelId     标签id
     * @param categoryId  分类id
     * @return int
     */
    @Override
    public int countByCondition(SubjectInfo subjectInfo, Long labelId, Long categoryId) {
        return this.subjectInfoDao.countByCondition(subjectInfo, labelId, categoryId);
    }


    /**
     * 分页查询
     *
     * @param subjectInfo 题目信息
     * @param labelId     标签id
     * @param categoryId  分类id
     * @param start       开始
     * @param pageSize    分页大小
     * @return {@link List }<{@link SubjectInfo }>
     */
    @Override
    public List<SubjectInfo> queryPage(SubjectInfo subjectInfo, Long labelId, Long categoryId, int start, Integer pageSize) {
        return this.subjectInfoDao.queryPage(subjectInfo,labelId,categoryId,start,pageSize);
    }


    /**
     * 按场景类型计数
     *
     * @param subjectInfo 题目信息
     * @param subjectType 题目类型
     * @return int
     */
    @Override
    public int countBySceneType(SubjectInfo subjectInfo, Long subjectType) {
        return this.subjectInfoDao.countBySceneType(subjectInfo, subjectType);
    }


    @Override
    public List<SubjectInfo> queryConditionByPage(SubjectInfo subjectInfo,Integer subjectType , int start, Integer pageSize) {
        return this.subjectInfoDao.queryConditionByPage(subjectInfo, subjectType, start, pageSize);
    }

    @Override
    public List<SubjectInfo> queryByCondition(SubjectInfo subjectInfo) {
        return this.subjectInfoDao.queryByCondition(subjectInfo);
    }

    /**
     * 按id获取题目
     *
     * @param subjectIdList 题目id列表
     * @return {@link List }<{@link SubjectInfo }>
     */
    @Override
    public List<SubjectInfo> getSubjectsByIds(List<Long> subjectIdList) {
        if (subjectIdList == null || subjectIdList.isEmpty()) {
            return Collections.emptyList(); // or throw an exception
        }
        return this.subjectInfoDao.getSubjectsByIds(subjectIdList);
    }
}

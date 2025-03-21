package com.cccs7.subject.infra.basic.service.impl;

import com.cccs7.subject.infra.basic.entity.SubjectScene;
import com.cccs7.subject.infra.basic.mapper.SubjectSceneDao;
import com.cccs7.subject.infra.basic.service.SubjectSceneService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 场景、面试题信息表(SubjectScene)表服务实现类
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-12 16:24:20
 */
@Service("subjectSceneService")
public class SubjectSceneServiceImpl implements SubjectSceneService {
    @Resource
    private SubjectSceneDao subjectSceneDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectScene queryById(Long id) {
        return this.subjectSceneDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param subjectScene 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectScene insert(SubjectScene subjectScene) {
        this.subjectSceneDao.insert(subjectScene);
        return subjectScene;
    }

    /**
     * 修改数据
     *
     * @param subjectScene 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectScene update(SubjectScene subjectScene) {
        this.subjectSceneDao.update(subjectScene);
        return this.queryById(subjectScene.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectSceneDao.deleteById(id) > 0;
    }


    @Override
    public int batchInsert(LinkedList<SubjectScene> suggestList) {
        return this.subjectSceneDao.insertBatch(suggestList);
    }


    /**
     * 按条件查询
     *
     * @param subjectId 题目ID
     * @return {@link List }<{@link SubjectScene }>
     */
    @Override
    public List<SubjectScene> queryByCondition(SubjectScene subjectScene) {
        return this.subjectSceneDao.queryByCondition(subjectScene);
    }
}

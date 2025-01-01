package com.cccs7.subject.infra.basic.service.impl;

import com.cccs7.subject.infra.basic.entity.SubjectLabel;
import com.cccs7.subject.infra.basic.mapper.SubjectLabelDao;
import com.cccs7.subject.infra.basic.service.SubjectLabelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


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
    public SubjectLabel update(SubjectLabel subjectLabel) {
        this.subjectLabelDao.update(subjectLabel);
        return this.queryById(subjectLabel.getId());
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
}

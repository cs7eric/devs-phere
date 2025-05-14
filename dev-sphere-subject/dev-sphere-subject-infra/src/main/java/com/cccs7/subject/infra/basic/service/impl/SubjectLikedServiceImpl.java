package com.cccs7.subject.infra.basic.service.impl;

import com.cccs7.subject.infra.basic.entity.SubjectLiked;
import com.cccs7.subject.infra.basic.mapper.SubjectLikedDao;
import com.cccs7.subject.infra.basic.service.SubjectLikedService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 题目点赞表(SubjectLiked)表服务实现类
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-05-15 00:02:13
 */
@Service("subjectLikedService")
public class SubjectLikedServiceImpl implements SubjectLikedService {
    @Resource
    private SubjectLikedDao subjectLikedDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectLiked queryById(Long id) {
        return this.subjectLikedDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param subjectLiked 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<SubjectLiked> queryByPage(SubjectLiked subjectLiked, PageRequest pageRequest) {
        long total = this.subjectLikedDao.count(subjectLiked);
        return new PageImpl<>(this.subjectLikedDao.queryAllByLimit(subjectLiked, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param subjectLiked 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectLiked insert(SubjectLiked subjectLiked) {
        this.subjectLikedDao.insert(subjectLiked);
        return subjectLiked;
    }

    /**
     * 修改数据
     *
     * @param subjectLiked 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectLiked update(SubjectLiked subjectLiked) {
        this.subjectLikedDao.update(subjectLiked);
        return this.queryById(subjectLiked.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectLikedDao.deleteById(id) > 0;
    }
}

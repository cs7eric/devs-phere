package com.cccs7.practice.infra.basic.service.impl;

import com.cccs7.practice.infra.basic.entity.PracticeDetail;
import com.cccs7.practice.infra.basic.dao.PracticeDetailDao;
import com.cccs7.practice.infra.basic.service.PracticeDetailService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 练习详情表(PracticeDetail)表服务实现类
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-28 00:40:02
 */
@Service("practiceDetailService")
public class PracticeDetailServiceImpl implements PracticeDetailService {
    @Resource
    private PracticeDetailDao practiceDetailDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PracticeDetail queryById(Long id) {
        return this.practiceDetailDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param practiceDetail 实例对象
     * @return 实例对象
     */
    @Override
    public PracticeDetail insert(PracticeDetail practiceDetail) {
        this.practiceDetailDao.insert(practiceDetail);
        return practiceDetail;
    }

    /**
     * 修改数据
     *
     * @param practiceDetail 实例对象
     * @return 实例对象
     */
    @Override
    public PracticeDetail update(PracticeDetail practiceDetail) {
        this.practiceDetailDao.update(practiceDetail);
        return this.queryById(practiceDetail.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.practiceDetailDao.deleteById(id) > 0;
    }
}

package com.cccs7.practice.infra.basic.service.impl;

import com.cccs7.practice.infra.basic.entity.PracticeSetDetail;
import com.cccs7.practice.infra.basic.dao.PracticeSetDetailDao;
import com.cccs7.practice.infra.basic.service.PracticeSetDetailService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 套题内容表(PracticeSetDetail)表服务实现类
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-28 00:40:03
 */
@Service("practiceSetDetailService")
public class PracticeSetDetailServiceImpl implements PracticeSetDetailService {
    @Resource
    private PracticeSetDetailDao practiceSetDetailDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PracticeSetDetail queryById(Long id) {
        return this.practiceSetDetailDao.queryById(id);
    }



    /**
     * 新增数据
     *
     * @param practiceSetDetail 实例对象
     * @return 实例对象
     */
    @Override
    public PracticeSetDetail insert(PracticeSetDetail practiceSetDetail) {
        this.practiceSetDetailDao.insert(practiceSetDetail);
        return practiceSetDetail;
    }

    /**
     * 修改数据
     *
     * @param practiceSetDetail 实例对象
     * @return 实例对象
     */
    @Override
    public PracticeSetDetail update(PracticeSetDetail practiceSetDetail) {
        this.practiceSetDetailDao.update(practiceSetDetail);
        return this.queryById(practiceSetDetail.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.practiceSetDetailDao.deleteById(id) > 0;
    }
}

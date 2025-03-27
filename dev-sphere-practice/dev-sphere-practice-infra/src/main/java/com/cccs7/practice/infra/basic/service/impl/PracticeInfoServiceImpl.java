package com.cccs7.practice.infra.basic.service.impl;

import com.cccs7.practice.infra.basic.entity.PracticeInfo;
import com.cccs7.practice.infra.basic.dao.PracticeInfoDao;
import com.cccs7.practice.infra.basic.service.PracticeInfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 练习表(PracticeInfo)表服务实现类
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-28 00:40:03
 */
@Service("practiceInfoService")
public class PracticeInfoServiceImpl implements PracticeInfoService {
    @Resource
    private PracticeInfoDao practiceInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PracticeInfo queryById(Long id) {
        return this.practiceInfoDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param practiceInfo 实例对象
     * @return 实例对象
     */
    @Override
    public PracticeInfo insert(PracticeInfo practiceInfo) {
        this.practiceInfoDao.insert(practiceInfo);
        return practiceInfo;
    }

    /**
     * 修改数据
     *
     * @param practiceInfo 实例对象
     * @return 实例对象
     */
    @Override
    public PracticeInfo update(PracticeInfo practiceInfo) {
        this.practiceInfoDao.update(practiceInfo);
        return this.queryById(practiceInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.practiceInfoDao.deleteById(id) > 0;
    }
}

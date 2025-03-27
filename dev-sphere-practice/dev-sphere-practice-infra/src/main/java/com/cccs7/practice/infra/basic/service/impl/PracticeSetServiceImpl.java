package com.cccs7.practice.infra.basic.service.impl;

import com.cccs7.practice.infra.basic.mapper.PracticeSetDao;
import com.cccs7.practice.infra.basic.entity.PracticeSet;
import com.cccs7.practice.infra.basic.service.PracticeSetService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * 套题信息表(PracticeSet)表服务实现类
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-28 00:40:03
 */
@Service("practiceSetService")
public class PracticeSetServiceImpl implements PracticeSetService {
    @Resource
    private PracticeSetDao practiceSetDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PracticeSet queryById(Long id) {
        return this.practiceSetDao.queryById(id);
    }



    /**
     * 新增数据
     *
     * @param practiceSet 实例对象
     * @return 实例对象
     */
    @Override
    public PracticeSet insert(PracticeSet practiceSet) {
        this.practiceSetDao.insert(practiceSet);
        return practiceSet;
    }

    /**
     * 修改数据
     *
     * @param practiceSet 实例对象
     * @return 实例对象
     */
    @Override
    public PracticeSet update(PracticeSet practiceSet) {
        this.practiceSetDao.update(practiceSet);
        return this.queryById(practiceSet.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.practiceSetDao.deleteById(id) > 0;
    }
}

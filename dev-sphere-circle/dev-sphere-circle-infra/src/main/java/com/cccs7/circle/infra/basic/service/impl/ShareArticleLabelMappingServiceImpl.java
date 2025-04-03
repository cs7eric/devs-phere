package com.cccs7.circle.infra.basic.service.impl;

import com.cccs7.circle.infra.basic.entity.ShareArticleLabelMapping;
import com.cccs7.circle.infra.basic.mapper.ShareArticleLabelMappingDao;
import com.cccs7.circle.infra.basic.service.ShareArticleLabelMappingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 文章标签关系表(ShareArticleLabelMapping)表服务实现类
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-04-03 22:48:20
 */
@Service("shareArticleLabelMappingService")
public class ShareArticleLabelMappingServiceImpl implements ShareArticleLabelMappingService {
    @Resource
    private ShareArticleLabelMappingDao shareArticleLabelMappingDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ShareArticleLabelMapping queryById(Long id) {
        return this.shareArticleLabelMappingDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param shareArticleLabelMapping 实例对象
     * @return 实例对象
     */
    @Override
    public ShareArticleLabelMapping insert(ShareArticleLabelMapping shareArticleLabelMapping) {
        this.shareArticleLabelMappingDao.insert(shareArticleLabelMapping);
        return shareArticleLabelMapping;
    }

    /**
     * 修改数据
     *
     * @param shareArticleLabelMapping 实例对象
     * @return 实例对象
     */
    @Override
    public ShareArticleLabelMapping update(ShareArticleLabelMapping shareArticleLabelMapping) {
        this.shareArticleLabelMappingDao.update(shareArticleLabelMapping);
        return this.queryById(shareArticleLabelMapping.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.shareArticleLabelMappingDao.deleteById(id) > 0;
    }
}

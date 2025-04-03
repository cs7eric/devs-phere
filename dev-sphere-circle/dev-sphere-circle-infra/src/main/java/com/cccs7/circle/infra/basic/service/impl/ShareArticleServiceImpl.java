package com.cccs7.circle.infra.basic.service.impl;

import com.cccs7.circle.infra.basic.entity.ShareArticle;
import com.cccs7.circle.infra.basic.mapper.ShareArticleDao;
import com.cccs7.circle.infra.basic.service.ShareArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文章信息(ShareArticle)表服务实现类
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-04-03 19:39:19
 */
@Service
public class ShareArticleServiceImpl implements ShareArticleService {
    @Resource
    private ShareArticleDao shareArticleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ShareArticle queryById(Long id) {
        return this.shareArticleDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param shareArticle 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(ShareArticle shareArticle) {
        return this.shareArticleDao.insert(shareArticle);
    }

    /**
     * 修改数据
     *
     * @param shareArticle 实例对象
     * @return 实例对象
     */
    @Override
    public ShareArticle update(ShareArticle shareArticle) {
        this.shareArticleDao.update(shareArticle);
        return this.queryById(shareArticle.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.shareArticleDao.deleteById(id) > 0;
    }


    @Override
    public List<ShareArticle> queryByCondition(ShareArticle shareArticle) {
        return this.shareArticleDao.queryByCondition(shareArticle);
    }
}

package com.cccs7.circle.infra.basic.dao;

import com.cccs7.circle.infra.basic.entity.ShareCommentReply;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 评论及回复信息(ShareCommentReply)表数据库访问层
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-27 23:34:16
 */
public interface ShareCommentReplyDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ShareCommentReply queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param shareCommentReply 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<ShareCommentReply> queryAllByLimit(ShareCommentReply shareCommentReply, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param shareCommentReply 查询条件
     * @return 总行数
     */
    long count(ShareCommentReply shareCommentReply);

    /**
     * 新增数据
     *
     * @param shareCommentReply 实例对象
     * @return 影响行数
     */
    int insert(ShareCommentReply shareCommentReply);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ShareCommentReply> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ShareCommentReply> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ShareCommentReply> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ShareCommentReply> entities);

    /**
     * 修改数据
     *
     * @param shareCommentReply 实例对象
     * @return 影响行数
     */
    int update(ShareCommentReply shareCommentReply);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}


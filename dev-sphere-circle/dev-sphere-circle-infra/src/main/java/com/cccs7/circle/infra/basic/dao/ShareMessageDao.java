package com.cccs7.circle.infra.basic.dao;

import com.cccs7.circle.infra.basic.entity.ShareMessage;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 消息表(ShareMessage)表数据库访问层
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-27 23:34:16
 */
public interface ShareMessageDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ShareMessage queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param shareMessage 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<ShareMessage> queryAllByLimit(ShareMessage shareMessage, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param shareMessage 查询条件
     * @return 总行数
     */
    long count(ShareMessage shareMessage);

    /**
     * 新增数据
     *
     * @param shareMessage 实例对象
     * @return 影响行数
     */
    int insert(ShareMessage shareMessage);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ShareMessage> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ShareMessage> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ShareMessage> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ShareMessage> entities);

    /**
     * 修改数据
     *
     * @param shareMessage 实例对象
     * @return 影响行数
     */
    int update(ShareMessage shareMessage);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}


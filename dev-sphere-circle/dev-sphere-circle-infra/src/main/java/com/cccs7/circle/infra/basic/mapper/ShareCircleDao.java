package com.cccs7.circle.infra.basic.mapper;

import com.cccs7.circle.infra.basic.entity.ShareCircle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 圈子信息(ShareCircle)表数据库访问层
 *
 * @author cccs7 - csq020611@gmail.com
 * @since 2025-03-30 21:18:46
 */
public interface ShareCircleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ShareCircle queryById(Long id);


    /**
     * 统计总行数
     *
     * @param shareCircle 查询条件
     * @return 总行数
     */
    long count(ShareCircle shareCircle);

    /**
     * 新增数据
     *
     * @param shareCircle 实例对象
     * @return 影响行数
     */
    int insert(ShareCircle shareCircle);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ShareCircle> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ShareCircle> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ShareCircle> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ShareCircle> entities);

    /**
     * 修改数据
     *
     * @param shareCircle 实例对象
     * @return 影响行数
     */
    int update(ShareCircle shareCircle);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 按条件查询
     *
     * @param circle 圆
     * @return {@link List }<{@link ShareCircle }>
     */
    List<ShareCircle> queryByCondition(ShareCircle circle);
}


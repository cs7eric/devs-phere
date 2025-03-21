package com.cccs7.subject.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SubjectCategoryBO implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 分类类型
     */
    private Integer categoryType;

    /**
     * 图标连接
     */
    private String imageUrl;

    /**
     * 父级id
     */
    private Long parentId;

    /**
     * 数量
     */
    private Integer count;

    private List<SubjectLabelBO> labelBOList;
}

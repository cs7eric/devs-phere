package com.cccs7.auth.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 分类请求实体
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/01/03
 */
@Data
public class PageInfo implements Serializable {


    private Integer pageNo = 1;

    private Integer pageSize = 20;

    public Integer getPageNo() {
        if (pageNo == null || pageNo < 1) {
            return 1;
        }
        return pageNo;
    }

    public Integer getPageSize() {

        if (pageSize == null || pageSize < 1 || pageSize > Integer.MAX_VALUE) {
            return 20;
        }
        return pageSize;
    }
}

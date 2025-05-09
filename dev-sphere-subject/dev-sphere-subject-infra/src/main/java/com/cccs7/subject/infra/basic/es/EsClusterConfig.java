package com.cccs7.subject.infra.basic.es;

import lombok.Data;

import java.io.Serializable;

/**
 * Es集群配置
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/05/06
 */
@Data
public class EsClusterConfig implements Serializable {


    /**
     * 集群名称
     */
    private String name;

    /**
     * 集群节点
     */
    private String nodes;
}

package com.cccs7.oss.config;

import com.cccs7.oss.adapter.AliyunStorageAdapter;
import com.cccs7.oss.adapter.MinioStorageAdapter;
import com.cccs7.oss.adapter.StorageAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * 存储配置类
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/02/27
 */
@Configuration
@RefreshScope
@EnableAutoConfiguration
public class StorageConfiguration {


    HashMap<String, StorageAdapter> adapterMap = new HashMap<>();


    @Value("${storage.service.type}")
    private String storageType;

    public StorageConfiguration() {
        adapterMap.put("minio", new MinioStorageAdapter());
        adapterMap.put("aliyun", new AliyunStorageAdapter());

    }

    @Bean
    @RefreshScope
    public StorageAdapter storageAdapter(){

        StorageAdapter adapter = adapterMap.get(storageType);
        if (adapter == null) throw new IllegalArgumentException("找到对应文件存储服务");
        return adapter;
    }
}

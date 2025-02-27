package com.cccs7.oss.service;

import com.cccs7.oss.adapter.StorageAdapter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件存储服务
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/02/27
 */
@Service
public class FileService {

    private final StorageAdapter storageAdapter;

    public FileService(StorageAdapter storageAdapter) {
        this.storageAdapter = storageAdapter;
    }

    /**
     * 获取url
     *
     * @param bucketName 桶名字
     * @param objectName 对象名称
     * @return {@link String }
     */
    public String getUrl(String bucketName, String objectName) {
        return storageAdapter.getUrl(bucketName, objectName);
    }

    /**
     * 上传文件
     *
     * @param uploadFile 上传文件
     * @param bucket     桶
     * @param objectName 对象名称
     * @return {@link String }
     */
    public String uploadFile(MultipartFile uploadFile, String bucket, String objectName) {
        storageAdapter.uploadFile(uploadFile, bucket, objectName);
        objectName = objectName + "/" + uploadFile.getOriginalFilename();
        return storageAdapter.getUrl(bucket, objectName);
    }
}

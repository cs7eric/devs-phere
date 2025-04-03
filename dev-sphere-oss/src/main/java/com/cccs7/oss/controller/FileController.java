package com.cccs7.oss.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.cccs7.oss.entity.Result;
import com.cccs7.oss.service.FileService;
import com.cccs7.oss.util.MinioUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文件controller
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/02/27
 */
@RestController
@RequestMapping("/oss/")
public class FileController {


    @Resource
    private FileService fileService;

    @Resource
    private MinioUtil minioUtil;


    @NacosValue(value = "${storage.service.type}", autoRefreshed = true)
    private String storageType;

    /**
     * 测试获得所有桶
     *
     * @return {@link String }
     * @throws Exception 异常
     */
    @RequestMapping("/testGetAllBucket")
    public Result testGetAllBucket() throws Exception {

        List<String> allBucket = fileService.getAllBucket();
        return Result.ok(allBucket);
    }


    /**
     * 获取url
     *
     * @param bucketName 桶名字
     * @param objectName 对象名称
     * @return {@link String }
     */
    @RequestMapping("/getUrl")
    public String getUrl(String bucketName, String objectName){

        return fileService.getUrl(bucketName, objectName);
    }

    /**
     * 上传文件
     *
     * @param uploadFile 上传文件
     * @param bucket     桶
     * @param objectName 对象名称
     * @return {@link Result }
     */
    @PostMapping("/upload")
    public Result uploadFile(
            @RequestParam("uploadFile") MultipartFile uploadFile, // 名称必须与前端的formData.append一致
            @RequestParam("bucket") String bucket,
            @RequestParam("objectName") String objectName
    ) {
        String url = fileService.uploadFile(uploadFile, bucket, objectName);
        return Result.ok(url);
    }
    @GetMapping("/testNacos")
    public String testNacos(){
        return storageType;
    }

}

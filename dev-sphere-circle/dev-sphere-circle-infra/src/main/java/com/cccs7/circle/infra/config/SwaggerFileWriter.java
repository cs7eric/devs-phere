package com.cccs7.circle.infra.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.io.FileWriter;
import java.io.IOException;

@Configuration
public class SwaggerFileWriter implements CommandLineRunner {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void run(String... args) throws Exception {
        writeApiDocsToFile();
    }

    private void writeApiDocsToFile() {
        String url = "http://localhost:8090/v2/api-docs?group=circle-service"; // 确保服务已启动并且URL正确
        String outputPath = "G:/project-repo/dev-sphere-front/circle-openapi.json"; // 指定输出路径

        try {
            String apiDocs = restTemplate.getForObject(url, String.class); // 获取 API 文档
            try (FileWriter fileWriter = new FileWriter(outputPath)) {
                fileWriter.write(apiDocs);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
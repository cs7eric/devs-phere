package com.cccs7.subject.infra.basic.es;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * es客户端
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/05/06
 */
@Slf4j
@Component
public class EsRestClient {


    private final Map<String, RestHighLevelClient> clientMap = new ConcurrentHashMap<>();

    @Resource
    private EsConfigProperties esConfigProperties;

    @PostConstruct
    public void initialize() {
        List<EsClusterConfig> esConfigs = esConfigProperties.getEsConfigs();
        for (EsClusterConfig esConfig : esConfigs) {
            log.info("initialize.config.name:{},node:{}", esConfig.getName(), esConfig.getNodes());
            // 初始化每个集群的客户端
            RestHighLevelClient restHighLevelClient = initRestClient(esConfig);
            if (restHighLevelClient != null) {
                clientMap.put(esConfig.getName(), restHighLevelClient);
            } else {
                log.error("config.name:{},node:{}.initError", esConfig.getName(), esConfig.getNodes());
            }
        }
    }

    private RestHighLevelClient initRestClient(EsClusterConfig esClusterConfig) {
        String[] ipPortAddr = esClusterConfig.getNodes().split(",");
        ArrayList<HttpHost> httpHostList = new ArrayList<>(ipPortAddr.length);
        for (String ipPort : ipPortAddr) {
            String[] ipPortInfo = ipPort.split(":");
            if (ipPortInfo.length == 2) {
                HttpHost httpPost = new HttpHost(ipPortInfo[0], NumberUtils.toInt(ipPortInfo[1]));
                httpHostList.add(httpPost);
            }
        }
        HttpHost[] httpHosts = new HttpHost[httpHostList.size()];
        httpHostList.toArray(httpHosts);

        RestClientBuilder builder = RestClient.builder(httpHosts);
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(builder);
        return restHighLevelClient;
    }

}

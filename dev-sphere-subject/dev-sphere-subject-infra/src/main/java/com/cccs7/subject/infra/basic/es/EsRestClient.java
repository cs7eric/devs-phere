package com.cccs7.subject.infra.basic.es;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.http.HttpHost;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.*;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.elasticsearch.index.reindex.UpdateByQueryRequest;
import org.elasticsearch.script.Script;
import org.elasticsearch.search.Scroll;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.elasticsearch.search.sort.ScoreSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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


    private static Map<String, RestHighLevelClient> clientMap = new ConcurrentHashMap<>();

    @Resource
    private EsConfigProperties esConfigProperties;

    private static final RequestOptions COMMON_OPTIONS;

    static {
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
        COMMON_OPTIONS = builder.build();
    }

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

    /**
     * 获取客户端
     *
     * @param clusterName 集群名称
     * @return {@link RestHighLevelClient }
     */
    private static RestHighLevelClient getClient(String clusterName) {
        return clientMap.get(clusterName);
    }

    /**
     * 插入文档
     *
     * @param esIndexInfo  Es索引信息
     * @param esSourceData Es源数据
     * @return boolean
     */
    public static boolean insertDoc(EsIndexInfo esIndexInfo, EsSourceData esSourceData) {

        try {
            IndexRequest indexRequest = new IndexRequest(esIndexInfo.getIndexName());
            indexRequest.source(esSourceData.getData());
            indexRequest.id(esSourceData.getDocId());
            getClient(esIndexInfo.getClusterName()).index(indexRequest, COMMON_OPTIONS);
            return true;
        } catch (IOException e) {
            log.error("insertDoc.exception:{}", e.getMessage(), e);
        }
        return false;
    }

    /**
     * 更新文档
     *
     * @param esIndexInfo  Es索引信息
     * @param esSourceData Es源数据
     * @return boolean
     */
    public static boolean updateDoc(EsIndexInfo esIndexInfo, EsSourceData esSourceData) {
        try {
            UpdateRequest updateRequest = new UpdateRequest();
            updateRequest.index(esIndexInfo.getIndexName());
            updateRequest.id(esSourceData.getDocId());
            updateRequest.doc(esSourceData.getData());
            getClient(esIndexInfo.getClusterName()).update(updateRequest, COMMON_OPTIONS);
            return true;
        } catch (Exception e) {
            log.error("updateDoc.exception:{}", e.getMessage(), e);
        }
        return false;
    }

    /**
     * 批量更新文档
     *
     * @param esIndexInfo      Es索引信息
     * @param esSourceDataList Es源数据列表
     * @return boolean
     */
    public static boolean batchUpdateDoc(EsIndexInfo esIndexInfo,
                                            List<EsSourceData> esSourceDataList) {
        try {
            boolean flag = false;
            BulkRequest bulkRequest = new BulkRequest();
            for (EsSourceData esSourceData : esSourceDataList) {
                String docId = esSourceData.getDocId();
                if (StringUtils.isNotBlank(docId)) {
                    UpdateRequest updateRequest = new UpdateRequest();
                    updateRequest.index(esIndexInfo.getIndexName());
                    updateRequest.id(esSourceData.getDocId());
                    updateRequest.doc(esSourceData.getData());
                    bulkRequest.add(updateRequest);
                    flag = true;
                }
            }

            if (flag) {
                BulkResponse bulk = getClient(esIndexInfo.getClusterName()).bulk(bulkRequest, COMMON_OPTIONS);
                if (bulk.hasFailures()) {
                    return false;
                }
            }

            return true;
        } catch (Exception e) {
            log.error("batchUpdateDoc.exception:{}", e.getMessage(), e);
        }
        return false;
    }

    /**
     * 删除
     *
     * @param esIndexInfo Es索引信息
     * @return boolean
     */
    public static boolean delete(EsIndexInfo esIndexInfo) {
        try {
            DeleteByQueryRequest deleteByQueryRequest =
                    new DeleteByQueryRequest(esIndexInfo.getIndexName());
            deleteByQueryRequest.setQuery(QueryBuilders.matchAllQuery());
            BulkByScrollResponse response = getClient(esIndexInfo.getClusterName()).deleteByQuery(
                    deleteByQueryRequest, COMMON_OPTIONS
            );
            long deleted = response.getDeleted();
            log.info("deleted.size:{}", deleted);
            return true;
        } catch (Exception e) {
            log.error("delete.exception:{}", e.getMessage(), e);
        }
        return false;
    }

    /**
     * 删除文档
     *
     * @param esIndexInfo Es索引信息
     * @param docId       文档id
     * @return boolean
     */
    public static boolean deleteDoc(EsIndexInfo esIndexInfo, String docId) {
        try {
            DeleteRequest deleteRequest = new DeleteRequest(esIndexInfo.getIndexName());
            deleteRequest.id(docId);
            DeleteResponse response = getClient(esIndexInfo.getClusterName()).delete(deleteRequest, COMMON_OPTIONS);
            log.info("deleteDoc.response:{}", JSON.toJSONString(response));
            return true;
        } catch (Exception e) {
            log.error("deleteDoc.exception:{}", e.getMessage(), e);
        }
        return false;
    }

    /**
     * 按id获取文档
     *
     * @param esIndexInfo Es索引信息
     * @param docId       文档id
     * @return {@link Map }<{@link String }, {@link Object }>
     */
    public static Map<String, Object> getDocById(EsIndexInfo esIndexInfo, String docId) {
        try {
            GetRequest getRequest = new GetRequest(esIndexInfo.getIndexName());
            getRequest.id(docId);
            GetResponse response = getClient(esIndexInfo.getClusterName()).get(getRequest, COMMON_OPTIONS);
            Map<String, Object> source = response.getSource();
            return source;
        } catch (Exception e) {
            log.error("isExistDocById.exception:{}", e.getMessage(), e);
        }
        return null;
    }

    /**
     * 按id获取文档
     *
     * @param esIndexInfo Es索引信息
     * @param docId       文档id
     * @param fields      字段
     * @return {@link Map }<{@link String }, {@link Object }>
     */
    public static Map<String, Object> getDocById(EsIndexInfo esIndexInfo, String docId,
                                                    String[] fields) {
        try {
            GetRequest getRequest = new GetRequest(esIndexInfo.getIndexName());
            getRequest.id(docId);
            FetchSourceContext fetchSourceContext = new FetchSourceContext(true, fields, null);
            getRequest.fetchSourceContext(fetchSourceContext);
            GetResponse response = getClient(esIndexInfo.getClusterName()).get(getRequest, COMMON_OPTIONS);
            Map<String, Object> source = response.getSource();
            return source;
        } catch (Exception e) {
            log.error("isExistDocById.exception:{}", e.getMessage(), e);
        }
        return null;
    }

    /**
     * 进行精确值查询
     *
     * @param esIndexInfo     Es索引信息
     * @param esSearchRequest 搜索请求
     * @return {@link SearchResponse }
     */
    public static SearchResponse searchWithTermQuery(EsIndexInfo esIndexInfo,
                                                        EsSearchRequest esSearchRequest) {
        try {
            BoolQueryBuilder bq = esSearchRequest.getBq();
            String[] fields = esSearchRequest.getFields();
            int from = esSearchRequest.getFrom();
            int size = esSearchRequest.getSize();
            Long minutes = esSearchRequest.getMinutes();
            Boolean needScroll = esSearchRequest.getNeedScroll();
            String sortName = esSearchRequest.getSortName();
            SortOrder sortOrder = esSearchRequest.getSortOrder();

            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            searchSourceBuilder.query(bq);
            searchSourceBuilder.fetchSource(fields, null).from(from).size(size);

            if (Objects.nonNull(esSearchRequest.getHighlightBuilder())) {
                searchSourceBuilder.highlighter(esSearchRequest.getHighlightBuilder());
            }

            if (StringUtils.isNotBlank(sortName)) {
                searchSourceBuilder.sort(sortName);
            }

            searchSourceBuilder.sort(new ScoreSortBuilder().order(SortOrder.DESC));

            SearchRequest searchRequest = new SearchRequest();
            searchRequest.searchType(SearchType.DEFAULT);
            searchRequest.indices(esIndexInfo.getIndexName());
            searchRequest.source(searchSourceBuilder);
            if (needScroll) {
                Scroll scroll = new Scroll(TimeValue.timeValueMinutes(minutes));
                searchRequest.scroll(scroll);
            }
            SearchResponse search = getClient(esIndexInfo.getClusterName()).search(searchRequest, COMMON_OPTIONS);
            return search;
        } catch (Exception e) {
            log.error("searchWithTermQuery.exception:{}", e.getMessage(), e);
        }
        return null;
    }

    public static boolean batchInsertDoc(EsIndexInfo esIndexInfo, List<EsSourceData> esSourceDataList) {
        if (log.isInfoEnabled()) {
            log.info("批量新增ES:" + esSourceDataList.size());
            log.info("indexName:" + esIndexInfo.getIndexName());
        }
        try {
            boolean flag = false;
            BulkRequest bulkRequest = new BulkRequest();

            for (EsSourceData source : esSourceDataList) {
                String docId = source.getDocId();
                if (StringUtils.isNotBlank(docId)) {
                    IndexRequest indexRequest = new IndexRequest(esIndexInfo.getIndexName());
                    indexRequest.id(docId);
                    indexRequest.source(source.getData());
                    bulkRequest.add(indexRequest);
                    flag = true;
                }
            }


            if (flag) {
                BulkResponse response = getClient(esIndexInfo.getClusterName()).bulk(bulkRequest, COMMON_OPTIONS);
                if (response.hasFailures()) {
                    return false;
                }
            }
        } catch (Exception e) {
            log.error("batchInsertDoc.error", e);
        }

        return true;
    }

    /**
     * 基于查询的批量更新
     *
     * @param esIndexInfo  Es索引信息
     * @param queryBuilder 查询构建器
     * @param script       脚本
     * @param batchSize    批量大小
     * @return boolean
     */
    public static boolean updateByQuery(EsIndexInfo esIndexInfo, QueryBuilder queryBuilder, Script script, int batchSize) {
        if (log.isInfoEnabled()) {
            log.info("updateByQuery.indexName:" + esIndexInfo.getIndexName());
        }
        try {
            UpdateByQueryRequest updateByQueryRequest = new UpdateByQueryRequest(esIndexInfo.getIndexName());
            updateByQueryRequest.setQuery(queryBuilder);
            updateByQueryRequest.setScript(script);
            updateByQueryRequest.setBatchSize(batchSize);
            updateByQueryRequest.setAbortOnVersionConflict(false);
            BulkByScrollResponse response = getClient(esIndexInfo.getClusterName()).updateByQuery(updateByQueryRequest, RequestOptions.DEFAULT);
            List<BulkItemResponse.Failure> failures = response.getBulkFailures();
        } catch (Exception e) {
            log.error("updateByQuery.error", e);
        }
        return true;
    }

    /**
     * 分词方法
     */
    public static List<String> getAnalyze(EsIndexInfo esIndexInfo, String text) throws Exception {
        List<String> list = new ArrayList<String>();
        Request request = new Request("GET", "_analyze");
        JSONObject entity = new JSONObject();
        entity.put("analyzer", "ik_smart");
        entity.put("text", text);
        request.setJsonEntity(entity.toJSONString());
        Response response = getClient(esIndexInfo.getClusterName()).getLowLevelClient().performRequest(request);
        JSONObject tokens = JSONObject.parseObject(EntityUtils.toString(response.getEntity()));
        JSONArray arrays = tokens.getJSONArray("tokens");
        for (int i = 0; i < arrays.size(); i++) {
            JSONObject obj = JSON.parseObject(arrays.getString(i));
            list.add(obj.getString("token"));
        }
        return list;
    }


}

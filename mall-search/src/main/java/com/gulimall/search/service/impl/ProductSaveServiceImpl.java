package com.gulimall.search.service.impl;

import com.alibaba.fastjson.JSON;
import com.gulimall.common.dto.es.SkuEsModel;
import com.gulimall.search.config.ElasticSearchConfig;
import com.gulimall.search.constant.EsConstant;
import com.gulimall.search.service.ProductSaveService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
public class ProductSaveServiceImpl implements ProductSaveService {
    @Resource
    private RestHighLevelClient restHighLevelClient;
    @Override
    public boolean productStatusUp(List<SkuEsModel> skuEsModels) throws IOException {
        BulkRequest bulkRequest=new BulkRequest();
        for (SkuEsModel model:skuEsModels){
            IndexRequest indexRequest = new IndexRequest(EsConstant.PRODUCT_INDEX);
            indexRequest.id(model.getSkuId().toString());
            String jsonString = JSON.toJSONString(model);
            indexRequest.source(jsonString, XContentType.JSON);
            bulkRequest.add(indexRequest);
        }
        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, ElasticSearchConfig.COMMON_OPTIONS);

        // TODO 批量执行错误，待处理
        boolean result = bulk.hasFailures();// 是否异常
        if (result) {
            List<String> ids = Arrays.stream(bulk.getItems()).filter(BulkItemResponse::isFailed)
                    .map(BulkItemResponse::getId).collect(Collectors.toList());
            log.error("商品上架错误：{}", ids);
        }
        return !result;
    }
}

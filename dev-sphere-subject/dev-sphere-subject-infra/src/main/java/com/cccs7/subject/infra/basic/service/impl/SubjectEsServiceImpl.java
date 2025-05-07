package com.cccs7.subject.infra.basic.service.impl;

import com.cccs7.subject.common.entity.PageResult;
import com.cccs7.subject.infra.basic.entity.EsSubjectFields;
import com.cccs7.subject.infra.basic.entity.SubjectInfoEs;
import com.cccs7.subject.infra.basic.es.EsIndexInfo;
import com.cccs7.subject.infra.basic.es.EsRestClient;
import com.cccs7.subject.infra.basic.es.EsSourceData;
import com.cccs7.subject.infra.basic.service.SubjectEsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SubjectEsServiceImpl implements SubjectEsService {

    @Override
    public boolean insert(SubjectInfoEs subjectInfoEs) {
        EsSourceData esSourceData = new EsSourceData();
        Map<String, Object> data = convert2EsSourceData(subjectInfoEs);
        esSourceData.setDocId(subjectInfoEs.getDocId().toString());
        esSourceData.setData(data);
        return EsRestClient.insertDoc(getEsIndexInfo(), esSourceData);
    }



    @Override
    public PageResult<SubjectInfoEs> querySubjectList(SubjectInfoEs subjectInfoEs) {
        return null;
    }

    private Map<String, Object> convert2EsSourceData(SubjectInfoEs subjectInfoEs) {
        Map<String,Object> data = new HashMap<>();
        data.put(EsSubjectFields.SUBJECT_ID,subjectInfoEs.getSubjectId());
        data.put(EsSubjectFields.DOC_ID,subjectInfoEs.getDocId());
        data.put(EsSubjectFields.SUBJECT_NAME,subjectInfoEs.getSubjectName());
        data.put(EsSubjectFields.SUBJECT_ANSWER,subjectInfoEs.getSubjectAnswer());
        data.put(EsSubjectFields.SUBJECT_TYPE,subjectInfoEs.getSubjectType());
        data.put(EsSubjectFields.CREATE_USER,subjectInfoEs.getCreateUser());
        data.put(EsSubjectFields.CREATE_TIME,subjectInfoEs.getCreateTime());
        return data;
    }


    private EsIndexInfo getEsIndexInfo() {
        EsIndexInfo esIndexInfo = new EsIndexInfo();
        esIndexInfo.setClusterName("6570b6c6d1dd");
        esIndexInfo.setIndexName("subject_index");
        return esIndexInfo;
    }
}

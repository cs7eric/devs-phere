package com.cccs7.subject.domain.handler.subject;

import com.cccs7.subject.common.enums.IsDeletedFlagEnum;
import com.cccs7.subject.common.enums.SubjectInfoTypeEnum;
import com.cccs7.subject.domain.convert.SceneSubjectConverter;
import com.cccs7.subject.domain.entity.SubjectInfoBO;
import com.cccs7.subject.domain.entity.SubjectOptionBO;
import com.cccs7.subject.domain.entity.SubjectSceneBO;
import com.cccs7.subject.infra.basic.entity.SubjectBrief;
import com.cccs7.subject.infra.basic.entity.SubjectScene;
import com.cccs7.subject.infra.basic.service.SubjectBriefService;
import com.cccs7.subject.infra.basic.service.SubjectSceneService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Component
public class SceneSubjectHandler implements SubjectTypeHandler {

    @Resource
    private SubjectBriefService subjectBriefService;

    @Resource
    private SubjectSceneService subjectSceneService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.SCENE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        LinkedList<SubjectScene> suggestList = new LinkedList<>();
        subjectInfoBO.getSuggestList()
                .forEach((scene) -> {
                    SubjectScene subjectScene = SceneSubjectConverter.INSTANCE.bo2po(scene);
                    subjectScene.setSubjectId(subjectInfoBO.getId());
                    subjectScene.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
                    suggestList.add(subjectScene);
                });
        subjectSceneService.batchInsert(suggestList);

        SubjectBrief subjectBrief = new SubjectBrief();
        subjectBrief.setSubjectId(Math.toIntExact(subjectInfoBO.getId()));
        subjectBrief.setSubjectAnswer(subjectInfoBO.getSubjectAnswer());
        subjectBrief.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectBriefService.insert(subjectBrief);
    }

    @Override
    public SubjectOptionBO query(int subjectId) {

        // 查询场景题 的提示信息
        List<SubjectScene> suggestList = subjectSceneService.queryByCondition(subjectId);
        List<SubjectSceneBO> suggestBOList = SceneSubjectConverter.INSTANCE.pos2bos(suggestList);
        SubjectOptionBO optionBO = new SubjectOptionBO();
        optionBO.setSuggestList(suggestBOList);

        // 查询题目答案
        SubjectBrief subjectBrief = subjectBriefService.queryById((long) subjectId);
        String answer = subjectBrief.getSubjectAnswer();
        optionBO.setSubjectAnswer(answer);;

        return optionBO;
    }
}

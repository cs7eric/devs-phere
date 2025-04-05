package com.cccs7.circle.convert;

import com.cccs7.circle.bo.ShareCircleMemberBO;
import com.cccs7.circle.infra.basic.entity.ShareCircleMember;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CircleMemberBOConverter {

    CircleMemberBOConverter INSTANCE = Mappers.getMapper(CircleMemberBOConverter.class);

    ShareCircleMemberBO po2bo(ShareCircleMember shareCircleMember);

    ShareCircleMember bo2po(ShareCircleMemberBO shareCircleMemberBO);
    // 自动生成 List 转换方法
    List<ShareCircleMemberBO> pos2bos(List<ShareCircleMember> shareCircleMembers);

    List<ShareCircleMember> bos2pos(List<ShareCircleMemberBO> shareCircleMemberBOs);
}

package com.cccs7.circle.application.convert;

import com.cccs7.circle.application.dto.CircleActionDTO;
import com.cccs7.circle.bo.ShareCircleMemberBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CircleActionConverter {

    CircleActionConverter INSTANCE =  Mappers.getMapper(CircleActionConverter.class);

    ShareCircleMemberBO action2MemberBO(CircleActionDTO circleActionDTO);


}

package com.cccs7.circle.convert;

import com.cccs7.circle.bo.ShareCircleBO;
import com.cccs7.circle.infra.basic.entity.ShareCircle;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CircleBOConverter {

    CircleBOConverter INSTANCE =  Mappers.getMapper(CircleBOConverter.class);

    ShareCircle bo2po(ShareCircleBO shareCircleBO);

    ShareCircleBO po2bo(ShareCircle shareCircle);

}

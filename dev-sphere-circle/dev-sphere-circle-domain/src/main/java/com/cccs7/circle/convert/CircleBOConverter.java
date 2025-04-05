package com.cccs7.circle.convert;

import com.cccs7.circle.bo.ShareCircleBO;
import com.cccs7.circle.infra.basic.entity.ShareCircle;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CircleBOConverter {

    CircleBOConverter INSTANCE =  Mappers.getMapper(CircleBOConverter.class);

    ShareCircle bo2po(ShareCircleBO shareCircleBO);

    ShareCircleBO po2bo(ShareCircle shareCircle);

    List<ShareCircleBO> pos2bos(List<ShareCircle> shareCircles);

    List<ShareCircle> bos2pos(List<ShareCircleBO> shareCircleBOS);

}

package com.cccs7.circle.application.convert;

import com.cccs7.circle.application.dto.ShareCircleDTO;
import com.cccs7.circle.bo.ShareCircleBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CircleDTOConverter {

    CircleDTOConverter INSTANCE =  Mappers.getMapper(CircleDTOConverter.class);

    ShareCircleBO dto2bo(ShareCircleDTO shareCircleDTO);

    ShareCircleDTO bo2dto(ShareCircleBO shareCircleBO);

    List<ShareCircleDTO> bos2dtos(List<ShareCircleBO> shareCircleBOS);

    List<ShareCircleBO> dtos2bos(List<ShareCircleDTO> shareCircleDTOS);

}

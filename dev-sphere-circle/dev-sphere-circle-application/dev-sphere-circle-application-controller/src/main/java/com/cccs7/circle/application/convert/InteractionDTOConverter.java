package com.cccs7.circle.application.convert;

import com.cccs7.circle.application.dto.InteractionDTO;
import com.cccs7.circle.bo.InteractionBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InteractionDTOConverter {

    InteractionDTOConverter INSTANCE = Mappers.getMapper(InteractionDTOConverter.class);

    InteractionBO dto2bo(InteractionDTO interactionDTO);
    InteractionDTO bo2dto(InteractionBO interactionBO);

}
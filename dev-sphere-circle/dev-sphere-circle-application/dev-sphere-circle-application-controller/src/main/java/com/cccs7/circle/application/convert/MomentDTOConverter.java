package com.cccs7.circle.application.convert;

import com.cccs7.circle.application.dto.ShareMomentDTO;
import com.cccs7.circle.bo.ShareMomentBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 动态BO converter
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/30
 */
@Mapper
public interface MomentDTOConverter {


    MomentDTOConverter INSTANCE = Mappers.getMapper(MomentDTOConverter.class);

    ShareMomentBO dto2bo(ShareMomentDTO shareMomentDTO);

    ShareMomentDTO bo2dto(ShareMomentBO shareMomentBO);

    List<ShareMomentDTO> bos2dtos(List<ShareMomentBO> shareMomentBOList);
}

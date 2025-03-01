package com.cccs7.auth.application.convert;

import com.cccs7.auth.application.dto.AuthUserDTO;
import com.cccs7.auth.entity.AuthUserBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 鉴权用户DTO Converter
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/01
 */
@Mapper
public interface AuthUserDTOConverter {

    AuthUserDTOConverter INSTANCE =  Mappers.getMapper(AuthUserDTOConverter.class);

    AuthUserDTO bo2dto(AuthUserBO authUserBo);

    AuthUserBO dto2bo(AuthUserDTO authUserDTO);

    List<AuthUserDTO> bos2dtos(List<AuthUserBO> authUserBoList);

    List<AuthUserBO> dtos2bos(List<AuthUserDTO> authUserBoList);


}

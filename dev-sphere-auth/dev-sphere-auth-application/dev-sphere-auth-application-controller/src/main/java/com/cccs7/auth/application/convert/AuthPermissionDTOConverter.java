package com.cccs7.auth.application.convert;

import com.cccs7.auth.application.dto.AuthPermissionDTO;
import com.cccs7.auth.entity.AuthPermissionBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 鉴权角色DTO Converter
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/01
 */
@Mapper
public interface AuthPermissionDTOConverter {

    AuthPermissionDTOConverter INSTANCE = Mappers.getMapper(AuthPermissionDTOConverter.class);

    AuthPermissionDTO bo2dto(AuthPermissionBO AuthPermissionBO);

    AuthPermissionBO dto2bo(AuthPermissionDTO AuthPermissionDTO);

    List<AuthPermissionDTO> bos2dtos(List<AuthPermissionBO> AuthPermissionBOList);

    List<AuthPermissionBO> dtos2bos(List<AuthPermissionDTO> AuthPermissionBOList);
}

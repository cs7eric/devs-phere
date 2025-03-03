package com.cccs7.auth.application.convert;

import com.cccs7.auth.application.dto.AuthRolePermissionDTO;
import com.cccs7.auth.entity.AuthRolePermissionBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 鉴权角色 DTO Converter
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/01
 */
@Mapper
public interface AuthRolePermissionDTOConverter {

    AuthRolePermissionDTOConverter INSTANCE = Mappers.getMapper(AuthRolePermissionDTOConverter.class);

    AuthRolePermissionDTO bo2dto(AuthRolePermissionBO authRolePermissionBO);

    AuthRolePermissionBO dto2bo(AuthRolePermissionDTO authRolePermissionDTO);

    List<AuthRolePermissionDTO> bos2dtos(List<AuthRolePermissionBO> authRolePermissionBOS);

    List<AuthRolePermissionBO> dtos2bos(List<AuthRolePermissionDTO> authRolePermissionDTOS);
}

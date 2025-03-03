package com.cccs7.auth.application.convert;

import com.cccs7.auth.application.dto.AuthRoleDTO;
import com.cccs7.auth.entity.AuthRoleBO;
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
public interface AuthRoleDTOConverter {

    AuthRoleDTOConverter INSTANCE = Mappers.getMapper(AuthRoleDTOConverter.class);

    AuthRoleDTO bo2dto(AuthRoleBO authRoleBO);

    AuthRoleBO dto2bo(AuthRoleDTO authRoleDTO);

    List<AuthRoleDTO> bos2dtos(List<AuthRoleBO> authRoleBoList);

    List<AuthRoleBO> dtos2bos(List<AuthRoleDTO> authRoleBoList);
}

package com.cccs7.auth.convert;

import com.cccs7.auth.basic.entity.AuthPermission;
import com.cccs7.auth.entity.AuthPermissionBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AuthPermissionBOConverter {

    AuthPermissionBOConverter INSTANCE =  Mappers.getMapper(AuthPermissionBOConverter.class);

    AuthPermissionBO po2bo(AuthPermission AuthPermission);

    AuthPermission bo2po(AuthPermissionBO AuthPermissionBO);

    List<AuthPermission> bos2pos(List<AuthPermissionBO> authUserBoList);

    List<AuthPermissionBO> pos2bos(List<AuthPermission> authUserList);
}

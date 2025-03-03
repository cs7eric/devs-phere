package com.cccs7.auth.convert;

import com.cccs7.auth.basic.entity.AuthRole;
import com.cccs7.auth.entity.AuthRoleBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AuthRoleBOConverter {

    AuthRoleBOConverter INSTANCE =  Mappers.getMapper(AuthRoleBOConverter.class);

    AuthRoleBO po2bo(AuthRole authRole);

    AuthRole bo2po(AuthRoleBO authRoleBO);

    List<AuthRole> bos2pos(List<AuthRoleBO> authUserBoList);

    List<AuthRoleBO> pos2bos(List<AuthRole> authUserList);
}

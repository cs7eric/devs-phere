package com.cccs7.auth.convert;

import com.cccs7.auth.basic.entity.AuthUser;
import com.cccs7.auth.entity.AuthUserBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AuthUserBOConverter {

    AuthUserBOConverter INSTANCE =  Mappers.getMapper(AuthUserBOConverter.class);

    AuthUserBO po2bo(AuthUser authUser);

    AuthUser bo2po(AuthUserBO authUserBO);

    List<AuthUser> bos2pos(List<AuthUserBO> authUserBoList);

    List<AuthUserBO> pos2bos(List<AuthUser> authUserList);
}

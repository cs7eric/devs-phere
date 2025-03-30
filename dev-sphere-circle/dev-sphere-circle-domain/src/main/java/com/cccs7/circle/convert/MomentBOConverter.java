package com.cccs7.circle.convert;

import com.cccs7.circle.bo.ShareMomentBO;
import com.cccs7.circle.infra.basic.entity.ShareMoment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 动态BO converter
 *
 * @author cccs7 - csq020611@gmail.com
 * @date 2025/03/30
 */
@Mapper
public interface MomentBOConverter {


    MomentBOConverter INSTANCE = Mappers.getMapper(MomentBOConverter.class);

    ShareMomentBO po2bo(ShareMoment shareMoment);

    ShareMoment bo2po(ShareMomentBO shareMomentBO);

}

package com.bosch.user.mapper;

import com.bosch.common.dto.UserDto;
import com.bosch.common.mapper.DefaultMapper;
import com.bosch.user.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {OrdersMapper.class})
public interface UserMapper extends DefaultMapper<UserEntity, UserDto> {
    @Mapping(source = "id", target = "orders", qualifiedByName = "findByUser")
    UserDto toDto(UserEntity entity);
}

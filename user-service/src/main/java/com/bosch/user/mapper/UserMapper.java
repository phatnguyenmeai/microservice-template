package com.bosch.user.mapper;

import com.bosch.common.dto.UserDto;
import com.bosch.common.mapper.DefaultMapper;
import com.bosch.user.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends DefaultMapper<UserEntity, UserDto> {
}

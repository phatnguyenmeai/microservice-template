package com.bosch.order.mapper;

import com.bosch.common.dto.OrderDto;
import com.bosch.common.mapper.DefaultMapper;
import com.bosch.order.entity.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper extends DefaultMapper<OrderEntity, OrderDto> {
}

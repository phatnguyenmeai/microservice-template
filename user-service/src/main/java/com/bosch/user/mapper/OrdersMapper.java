package com.bosch.user.mapper;

import com.bosch.common.api.OrderAPI;
import com.bosch.common.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
@RequiredArgsConstructor
public abstract class OrdersMapper {
    private final OrderAPI orderAPI;

    List<OrderDto> findByUser(String userId) throws Exception {
        return orderAPI.findByUserId(userId).getBody();
    }
}

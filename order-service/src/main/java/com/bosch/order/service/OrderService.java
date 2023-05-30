package com.bosch.order.service;

import com.bosch.common.dto.OrderDto;
import com.bosch.common.service.DefaultService;

import java.util.List;

public interface OrderService extends DefaultService<OrderDto, String> {
    List<OrderDto> findByUser(String userId);
}

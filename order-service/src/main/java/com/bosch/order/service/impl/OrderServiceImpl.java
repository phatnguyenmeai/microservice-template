package com.bosch.order.service.impl;

import com.bosch.common.dto.OrderDto;
import com.bosch.order.entity.OrderEntity;
import com.bosch.order.mapper.OrderMapper;
import com.bosch.order.repository.OrderRepository;
import com.bosch.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public OrderDto save(OrderDto item) {
        OrderEntity orderEntity = orderMapper.toEntity(item);
        orderEntity = orderRepository.save(orderEntity);
        return orderMapper.toDto(orderEntity);
    }

    @Override
    public List<OrderDto> saveAll(List<OrderDto> items) {

        List<String> orderIds = items.stream().map(OrderDto::getId).collect(Collectors.toList());
        List<OrderEntity> foundOrders = orderRepository.findAllById(orderIds);
        return foundOrders.stream().map(orderMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public OrderDto update(OrderDto item) throws Exception {
        OrderEntity orderEntity = orderRepository.findById(item.getId()).orElseThrow(() -> new Exception("Order not found"));
        orderEntity.setProductId(item.getProductId());
        orderEntity.setUpdatedAt(item.getUpdatedAt());
        return orderMapper.toDto(orderRepository.save(orderEntity));
    }

    @Override
    public OrderDto findById(String id) throws Exception {
        return orderMapper.toDto(orderRepository.findById(id).orElseThrow(() -> new Exception("Order not found")));
    }

    @Override
    public Page<OrderDto> findAll(Pageable pageable) {
        Page<OrderEntity> orderEntities = orderRepository.findAll(pageable);
        return orderEntities.map(orderMapper::toDto);
    }

    @Override
    public void deleteById(String id) throws Exception {
        OrderEntity orderEntity = orderRepository.findById(id).orElseThrow(() -> new Exception("Order not found"));
        orderEntity.setDelete(true);
        orderRepository.save(orderEntity);
    }

    @Override
    public void deleteAll() {
        List<OrderEntity> orderEntities = orderRepository.findAll();
        orderEntities.forEach(orderEntity -> orderEntity.setDelete(true));
        orderRepository.saveAll(orderEntities);
    }

    @Override
    public List<OrderDto> findByUser(String userId) {
        List<OrderEntity> orderEntities = orderRepository.findByUserId(userId);
        return orderEntities.stream().map(orderMapper::toDto).collect(Collectors.toList());
    }
}

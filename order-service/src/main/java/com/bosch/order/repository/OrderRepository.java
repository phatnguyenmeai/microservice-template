package com.bosch.order.repository;

import com.bosch.order.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<OrderEntity, String> {
    List<OrderEntity> findAllById(List<String> ids);
    List<OrderEntity> findByUserId(String userId);
}

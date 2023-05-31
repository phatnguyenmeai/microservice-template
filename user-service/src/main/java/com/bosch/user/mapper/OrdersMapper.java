package com.bosch.user.mapper;

import com.bosch.common.api.OrderAPI;
import com.bosch.common.dto.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Mapper(componentModel = "spring")
@Slf4j
public abstract class OrdersMapper {
    @Autowired
    OrderAPI orderAPI;
    @Value("${server.port}")
    private String port;

    List<OrderDto> findByUser(String userId) throws Exception {
        log.info("Fetching orders for user: {} from: {}", userId, port);
        return orderAPI.findByUserId(userId).getBody();
    }

    /**
     * This method is used to get the orders of a user --> This is a workaround for the above method
     *
     * @param userId
     * @return
     */
//    List<OrderDto> findByUser(String userId) {
//        log.info("Fetching orders for user: {} from: {}", userId, port);
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<OrderDto[]> result = restTemplate.getForEntity("http://localhost:4999/order-api/orders/user/{userId}", OrderDto[].class, userId);
//        return List.of(Objects.requireNonNull(result.getBody()));
//    }
}

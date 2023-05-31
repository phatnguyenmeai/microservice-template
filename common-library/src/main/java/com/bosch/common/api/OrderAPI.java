package com.bosch.common.api;

import com.bosch.common.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "order-service", path = "/order-api/orders")
public interface OrderAPI {
    @GetMapping("/")
    ResponseEntity<Page<OrderDto>> findAll(@RequestParam(name = "page", defaultValue = "0") int page,
                                           @RequestParam(name = "size", defaultValue = "10") int size,
                                           @RequestParam(name = "sortBy", defaultValue = "createdAt") String sortBy,
                                           @RequestParam(name = "sortDir", defaultValue = "desc") String sortDir) throws Exception;

    @GetMapping("/{id}")
    ResponseEntity<OrderDto> findById(@PathVariable("id") String id) throws Exception;

    @PostMapping("/")
    ResponseEntity<OrderDto> save(@RequestBody OrderDto OrderDto) throws Exception;

    @PutMapping("/{id}")
    ResponseEntity<OrderDto> update(@PathVariable(value = "id") String id, @RequestBody OrderDto OrderDto) throws Exception;

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable("id") String id) throws Exception;

    @GetMapping("/user/{userId}")
    ResponseEntity<List<OrderDto>> findByUserId(@PathVariable("userId") String userId) throws Exception;
}

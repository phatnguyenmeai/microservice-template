package com.bosch.order.controller;

import com.bosch.common.api.OrderAPI;
import com.bosch.common.dto.OrderDto;
import com.bosch.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
@Slf4j
public class OrderController implements OrderAPI {
    private final OrderService orderService;

    @Override
    @GetMapping("/")
    public ResponseEntity<Page<OrderDto>> findAll(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "10") int size,
                                                  @RequestParam(defaultValue = "createdAt") String sortBy,
                                                  @RequestParam(defaultValue = "desc") String sortDir) throws Exception {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDir), sortBy));
        return ResponseEntity.ok(orderService.findAll(pageable));
    }


    @Override
    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> findById(@PathVariable("id") String id) throws Exception {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<OrderDto> save(@RequestBody OrderDto OrderDto) throws Exception {
        return ResponseEntity.ok(orderService.save(OrderDto));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> update(@PathVariable("id") String id, OrderDto OrderDto) throws Exception {
        return ResponseEntity.ok(orderService.update(OrderDto));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") String id) throws Exception {
        orderService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderDto>> findByUserId(String userId) throws Exception {
        log.info("findByUserId: userId={}", userId);
        return ResponseEntity.ok(orderService.findByUser(userId));
    }
}

package com.bosch.common.api;

import com.bosch.common.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "user-service")
public interface UserAPI {
    @GetMapping("/users")
    ResponseEntity<List<UserDto>> findAll();

    @GetMapping("/users/{id}")
    ResponseEntity<UserDto> findById(@PathVariable("id") String id);

    @PostMapping("/users")
    ResponseEntity<UserDto> save(@RequestBody UserDto userDto);

    @PutMapping("/users/{id}")
    ResponseEntity<UserDto> update(@PathVariable("id") String id, @RequestBody UserDto userDto);

    @DeleteMapping("/users/{id}")
    ResponseEntity<Void> deleteById(@PathVariable("id") String id);
}

package com.bosch.common.api;

import com.bosch.common.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "user-service", path = "/users")
public interface UserAPI {
    @GetMapping("")
    ResponseEntity<Page<UserDto>> findAll(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "10") int size,
                                          @RequestParam(defaultValue = "createdAt") String sortBy,
                                          @RequestParam(defaultValue = "desc") String sortDir) throws Exception;

    @GetMapping("/{id}")
    ResponseEntity<UserDto> findById(@PathVariable("id") String id) throws Exception;

    @PostMapping("/")
    ResponseEntity<UserDto> save(@RequestBody UserDto userDto) throws Exception;

    @PutMapping("/{id}")
    ResponseEntity<UserDto> update(@PathVariable("id") String id, @RequestBody UserDto userDto) throws Exception;

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable("id") String id) throws Exception;
}

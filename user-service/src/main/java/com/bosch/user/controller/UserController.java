package com.bosch.user.controller;

import com.bosch.common.api.UserAPI;
import com.bosch.common.dto.UserDto;
import com.bosch.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController implements UserAPI {
    private final UserService userService;

    @Override
    @GetMapping
    public ResponseEntity<Page<UserDto>> findAll(@RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "10") int size,
                                                 @RequestParam(defaultValue = "createdAt") String sortBy,
                                                 @RequestParam(defaultValue = "desc") String sortDir) throws Exception {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDir), sortBy));
        return ResponseEntity.ok(userService.findAll(pageable));
    }


    @Override
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable("id") String id) throws Exception {
        return ResponseEntity.ok(userService.findById(id));
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) throws Exception {
        return ResponseEntity.ok(userService.save(userDto));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable("id") String id, UserDto userDto) throws Exception {
        return ResponseEntity.ok(userService.update(userDto));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") String id) throws Exception {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

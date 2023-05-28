package com.bosch.user.service.impl;

import com.bosch.common.dto.UserDto;
import com.bosch.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserDto save(UserDto item) throws Exception {
        return null;
    }

    @Override
    public List<UserDto> saveAll(List<UserDto> items) throws Exception {
        return null;
    }

    @Override
    public UserDto update(UserDto item) throws Exception {
        return null;
    }

    @Override
    public UserDto findById(String id) throws Exception {
        return null;
    }

    @Override
    public List<UserDto> findAll() throws Exception {
        return null;
    }

    @Override
    public void deleteById(String id) throws Exception {

    }

    @Override
    public void deleteAll() throws Exception {

    }
}

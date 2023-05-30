package com.bosch.user.service.impl;

import com.bosch.common.dto.UserDto;
import com.bosch.user.entity.UserEntity;
import com.bosch.user.mapper.UserMapper;
import com.bosch.user.repository.UserRepository;
import com.bosch.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto save(UserDto item) throws Exception {

        Optional<UserEntity> foundUser = userRepository.findByEmail(item.getEmail());
        if (foundUser.isEmpty()) {
            UserEntity userEntity = userMapper.toEntity(item);
            userEntity.setId(UUID.randomUUID().toString());
            userEntity.setDelete(false);
            return userMapper.toDto(userRepository.save(userEntity));
        } else {
            throw new Exception("User already exists");
        }
    }

    @Override
    public List<UserDto> saveAll(List<UserDto> items) {
        List<String> userIds = items.stream().map(UserDto::getId).collect(Collectors.toList());
        List<UserEntity> foundUsers = userRepository.findAllById(userIds);
        return foundUsers.stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDto update(UserDto item) throws Exception {

        UserEntity userEntity = userRepository.findById(item.getId()).orElseThrow(() -> new Exception("User not found"));
        userEntity.setFirstName(item.getFirstName());
        userEntity.setLastName(item.getLastName());
        userEntity.setEmail(item.getEmail());
        userEntity.setUpdatedAt(item.getUpdatedAt());
        return userMapper.toDto(userRepository.save(userEntity));
    }

    @Override
    public UserDto findById(String id) throws Exception {
        Optional<UserEntity> foundUser = userRepository.findById(id);
        if (foundUser.isPresent()) {
            return userMapper.toDto(foundUser.get());
        } else {
            throw new Exception("User not found");
        }
    }

    @Override
    public Page<UserDto> findAll(Pageable pageable) {
        Page<UserEntity> foundUsers = userRepository.findAll(pageable);
        return foundUsers.map(userMapper::toDto);
    }

    @Override
    public void deleteById(String id) throws Exception {
        Optional<UserEntity> foundUser = userRepository.findById(id);
        if (foundUser.isPresent()) {
            UserEntity userEntity = foundUser.get();
            userEntity.setDelete(true);
            userRepository.save(userEntity);
        } else {
            throw new Exception("User not found");
        }
    }

    @Override
    public void deleteAll() throws Exception {
        List<UserEntity> foundUsers = userRepository.findAll();
        foundUsers.forEach(userEntity -> userEntity.setDelete(true));
        userRepository.saveAll(foundUsers);
    }
}

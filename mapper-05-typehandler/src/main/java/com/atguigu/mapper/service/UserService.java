package com.atguigu.mapper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.mapper.entity.User;
import com.atguigu.mapper.mapper.UserMapper;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void saveUser(User user) {
        userMapper.insert(user);
    }

    public User getUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

}

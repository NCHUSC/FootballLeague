package com.example.service.impl;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    //保存用户
    @Transactional
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    //删除用户
    @Transactional
    @Override
    public void deleteUser(int user_id) {
        userRepository.deleteById(user_id);
    }

    //修改用户
    @Transactional
    @Override
    public User modifyUser(User user) {
        return userRepository.save(user);
    }

    //通过id获取用户
    @Override
    public User getUserById(int user_id) {
        return userRepository.getOne(user_id);
    }

    //通过账号获取用户
    @Override
    public User getUserByAccount(String account) {
        return userRepository.findByAccount(account);
    }

    //获取所有用户列表
    @Override
    public List<User> userList() {
        return userRepository.findAll();
    }

}

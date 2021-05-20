package com.example.service;

import com.example.model.User;

import java.util.List;

public interface UserService {

    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    User saveUser(User user);

    /**
     * 删除用户
     *
     * @param user_id
     */
    void deleteUser(int user_id);

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    User modifyUser(User user);

    /**
     * 通过id获取用户
     *
     * @param user_id
     * @return
     */
    User getUserById(int user_id);

    /**
     * 通过账号获取用户
     *
     * @param account
     * @return
     */
    User getUserByAccount(String account);

    /**
     * 获取所有用户列表
     *
     * @return
     */
    List<User> userList();
}

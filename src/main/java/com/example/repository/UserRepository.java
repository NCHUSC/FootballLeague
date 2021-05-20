package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * 通过账号密码查询
     *
     * @param account
     * @param password
     * @return
     */
    public User findByAccountAndPassword(String account, String password);

    /**
     * 通过账号查询
     *
     * @param account
     * @return
     */
    public User findByAccount(String account);

    /**
     * 通过昵称查询
     */
    //public List<User> findByNickname(String nickname);
}

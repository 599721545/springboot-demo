package com.example.demo.study.jdbc.service;

import com.example.demo.study.jdbc.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JdbcService {
    public void createUser(String name, Integer age);

    /**
     * 增伤改查
     * @return
     */
    List<User> findAll();
    User findById(int userId);
    int create(String userName,int userAge,String userSex);
    int update(String userName, int userAge, String userSex, int userId);
    int delete(int userId);
}

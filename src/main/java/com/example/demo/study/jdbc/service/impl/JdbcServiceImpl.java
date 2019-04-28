package com.example.demo.study.jdbc.service.impl;

import com.example.demo.study.jdbc.bean.User;
import com.example.demo.study.jdbc.service.JdbcService;
import com.example.demo.study.jdbc.service.MyRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JdbcServiceImpl implements JdbcService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void createUser(String name, Integer age) {
        System.out.println("ssss");
        jdbcTemplate.update("insert into users values(?,?);", name, age);
    }

    @Override
    public List<User> findAll() {
        String sql = "select * from t_user";
        List<User> userList = jdbcTemplate.query(sql,new MyRowMapper() );
        return userList;
    }

    @Override
    public User findById(int userId) {
        String sql = "select * from t_user where user_id = ?";
        User user = jdbcTemplate.queryForObject(sql,new MyRowMapper(),userId);
        return user;
    }

    @Override
    public int create(String userName, int userAge, String userSex) {
        String sql = "insert into t_user(user_name,user_age,user_sex) values(?,?,?)";
        return jdbcTemplate.update(sql,userName,userAge,userSex);
    }

    @Override
    public int update(String userName, int userAge, String userSex, int userId) {
        String sql = "update t_user set user_name = ? , user_age = ? , user_sex = ? where user_id = ?";
        return jdbcTemplate.update(sql, userName,userAge,userSex,userId);
    }

    @Override
    public int delete(int userId) {
        String sql = "delete from t_user where user_id = ?";
        return jdbcTemplate.update(sql,userId);
    }

}

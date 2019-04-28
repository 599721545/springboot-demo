package com.example.demo.study.jdbc.service;

import com.example.demo.study.jdbc.bean.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        //此处要使用表中的字段，不能使用属性
        int userId = resultSet.getInt("user_id");
        String userName = resultSet.getString("user_name");
        int userAge = resultSet.getInt("user_age");
        String userSex = resultSet.getString("user_sex");
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setUserAge(userAge);
        user.setUserSex(userSex);
        return user;
    }
}

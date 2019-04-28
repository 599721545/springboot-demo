package com.example.demo.study.jdbc.bean;

public class User {
    private int userId;
    private String userName;
    private int userAge;
    private String userSex;
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getUserAge() {
        return userAge;
    }
    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }
    public String getUserSex() {
        return userSex;
    }
    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }
    public User(String userName, int userAge, String userSex) {
        super();
        this.userName = userName;
        this.userAge = userAge;
        this.userSex = userSex;
    }
    public User() {
        super();
    }
    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", userAge=" + userAge + ", userSex=" + userSex
                + "]";
    }
}

package com.example.vo;

public class UserVO {
    private static String userid;
    private String password;
    private static String username;
    public static String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public static String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}

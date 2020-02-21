package com.leekwok.msuser.dto;

/**
 * <b>Author</b>: Xiang Liguo<br/>
 * <b>Date</b>: 2020/02/21 15:03<br/>
 * <b>Version</b>: 1.0<br/>
 * <b>Subject</b>: <br/>
 * <b>Description</b>: 用户登录 DTO
 */
public class UserLoginDTO {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

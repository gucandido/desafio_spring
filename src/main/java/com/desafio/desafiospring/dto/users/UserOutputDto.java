package com.desafio.desafiospring.dto.users;

import com.desafio.desafiospring.entities.user.User;

public class UserOutputDto {

    private long userId;
    private String userName;

    public UserOutputDto(long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static UserOutputDto classToDto(User user){
        return new UserOutputDto(user.getUserId(),user.getUserName());
    }
}

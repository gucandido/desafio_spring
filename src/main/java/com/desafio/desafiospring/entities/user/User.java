package com.desafio.desafiospring.entities.user;

import com.desafio.desafiospring.dto.users.UserDto;
import com.desafio.desafiospring.enums.UserType;

import java.util.ArrayList;
import java.util.List;

public class User {

    private long userId;
    private String userName;
    private List<User> followers;
    private List<User> followed;
    private UserType type;

    public User() {
    }

    public User(UserDto user) {
        this.userName = user.getUserName();
        this.followers = new ArrayList<>();
        this.followed = new ArrayList<>();
        this.type = user.getType();
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

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<User> getFollowed() {
        return followed;
    }

    public void setFollowed(List<User> followed) {
        this.followed = followed;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
}

package com.desafio.desafiospring.entities.user;

import com.desafio.desafiospring.dto.response.users.UserDto;

import java.util.ArrayList;
import java.util.List;

public class User {

    private long userId;
    private String userName;
    private List<User> followers;
    private List<User> followed;

    public User() {
    }

    public User(UserDto user) {
        this.userName = user.getUserName();
        this.followers = new ArrayList<>();
        this.followed = new ArrayList<>();
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

}

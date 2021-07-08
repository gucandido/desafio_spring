package com.desafio.desafiospring.dto.users;

import com.desafio.desafiospring.entities.user.User;

import java.util.ArrayList;
import java.util.List;

public class FollowersDto {

    public long userId;
    public String userName;
    public List<UserOutputDto> followers = new ArrayList<>();

    public FollowersDto(User user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();

        user.getFollowers().forEach(x->this.followers.add(UserOutputDto.classToDto(x)));
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

    public List<UserOutputDto> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserOutputDto> followers) {
        this.followers = followers;
    }
}

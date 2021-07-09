package com.desafio.desafiospring.dto.users;

import com.desafio.desafiospring.entities.user.User;

import java.util.ArrayList;
import java.util.List;

public class FollowedDto {

    public long userId;
    public String userName;
    public List<UserOutputDto> followed = new ArrayList<>();
    
    public FollowedDto(User user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();

        user.getFollowed().forEach(x->this.followed.add(UserOutputDto.classToDto(x)));
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

    public List<UserOutputDto> getFollowed() {
        return followed;
    }

    public void setFollowed(List<UserOutputDto> followed) {
        this.followed = followed;
    }
}

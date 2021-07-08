package com.desafio.desafiospring.dto.response.users;

import com.desafio.desafiospring.entities.user.User;

public class FollowersCountDto {

    public long userId;
    public String userName;
    public long followers_count;

    public FollowersCountDto(User u) {
        this.userId = u.getUserId();
        this.userName = u.getUserName();
        this.followers_count = u.getFollowers().size();
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

    public long getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(long followers_count) {
        this.followers_count = followers_count;
    }

}

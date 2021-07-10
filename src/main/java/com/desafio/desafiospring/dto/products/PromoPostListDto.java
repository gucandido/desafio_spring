package com.desafio.desafiospring.dto.products;

import com.desafio.desafiospring.entities.user.User;

import java.util.List;

public class PromoPostListDto extends FollowedPostsOutputDto{

    private String userName;

    public PromoPostListDto(User user, List<? extends PostOutputDto> posts) {
        super(user.getUserId(), posts);
        this.userName = user.getUserName();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

package com.desafio.desafiospring.dto.products;

import java.util.List;

public class FollowedPostsOutputDto {

    private long userId;
    private List<? extends PostOutputDto> posts;

    public FollowedPostsOutputDto(long userId, List<? extends PostOutputDto> posts) {
        this.userId = userId;
        this.posts = posts;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<? extends PostOutputDto> getPosts() {
        return posts;
    }

    public void setPosts(List<PostOutputDto> posts) {
        this.posts = posts;
    }

}

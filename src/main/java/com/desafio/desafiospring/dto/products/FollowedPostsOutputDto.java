package com.desafio.desafiospring.dto.products;

import java.util.List;

public class FollowedPostsOutputDto {

    private long userId;
    private List<PostOutputDto> posts;

    public FollowedPostsOutputDto(long userId, List<PostOutputDto> posts) {
        this.userId = userId;
        this.posts = posts;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<PostOutputDto> getPosts() {
        return posts;
    }

    public void setPosts(List<PostOutputDto> posts) {
        this.posts = posts;
    }

}

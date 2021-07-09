package com.desafio.desafiospring.dto.products;

import java.util.List;

public class FollowedPostsOutputDto {

    private long userId;
    private List<PostOutPutDto> posts;

    public FollowedPostsOutputDto(long userId, List<PostOutPutDto> posts) {
        this.userId = userId;
        this.posts = posts;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<PostOutPutDto> getPosts() {
        return posts;
    }

    public void setPosts(List<PostOutPutDto> posts) {
        this.posts = posts;
    }

}

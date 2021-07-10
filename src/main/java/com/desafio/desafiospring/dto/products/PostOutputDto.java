package com.desafio.desafiospring.dto.products;

import com.desafio.desafiospring.entities.products.Post;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PostOutputDto implements Comparable{

    protected long idPost;
    protected LocalDate date;
    protected DetailDto detail;
    protected long category;
    protected BigDecimal price;

    public PostOutputDto(Post post) {
        this.idPost = post.getIdPost();
        this.date = post.getDate();
        this.category = post.getCategory();
        this.price = post.getPrice();

        this.detail = DetailDto.classToDto(post.getDetail());
    }

    public long getIdPost() {
        return idPost;
    }

    public void setIdPost(long idPost) {
        this.idPost = idPost;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public DetailDto getDetail() {
        return detail;
    }

    public void setDetail(DetailDto detail) {
        this.detail = detail;
    }

    public long getCategory() {
        return category;
    }

    public void setCategory(long category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public static PostOutputDto classToDto(Post post){
        return new PostOutputDto(post);
    }

    @Override
    public int compareTo(Object o) {
        return Long.compare(this.idPost,((PostOutputDto) o).getIdPost());
    }
}

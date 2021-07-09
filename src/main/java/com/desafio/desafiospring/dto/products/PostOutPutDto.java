package com.desafio.desafiospring.dto.products;

import com.desafio.desafiospring.entities.products.Post;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PostOutPutDto implements Comparable{

    private long idPost;
    private LocalDate date;
    private DetailDto detail;
    private long category;
    private BigDecimal price;

    public PostOutPutDto(Post post) {
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

    public static PostOutPutDto classToDto(Post post){
        return new PostOutPutDto(post);
    }

    @Override
    public int compareTo(Object o) {
        return Long.compare(this.idPost,((PostOutPutDto) o).getIdPost());
    }
}

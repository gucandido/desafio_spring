package com.desafio.desafiospring.entities.products;

import com.desafio.desafiospring.dto.products.DetailDto;
import com.desafio.desafiospring.dto.products.PostInputDto;
import com.desafio.desafiospring.entities.user.User;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Post {

    private User user;
    private long idPost;
    private LocalDate date;

    private Detail detail;

    private long category;
    private BigDecimal price;

    private boolean hasPromo;
    private BigDecimal discount;

    public Post(User user, LocalDate date, long category, BigDecimal price, boolean hasPromo, BigDecimal discount) {
        this.user = user;
        this.date = date;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public Post(User user, LocalDate date, long category, BigDecimal price) {
        this.user = user;
        this.date = date;
        this.category = category;
        this.price = price;
        this.hasPromo = false;
        this.discount = BigDecimal.valueOf(0.0);
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getIdPost() {
        return idPost;
    }

    public void setIdPost(long id_post) {
        this.idPost = id_post;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
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

    public boolean isHasPromo() {
        return hasPromo;
    }

    public void setHasPromo(boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}

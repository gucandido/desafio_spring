package com.desafio.desafiospring.dto.products;

import com.desafio.desafiospring.entities.products.Post;

import java.math.BigDecimal;

public class PromoPostOutputDto extends PostOutputDto implements Comparable {

    private Boolean hasPromo;
    private BigDecimal discount;

    public PromoPostOutputDto(Post post) {
        super(post);
        this.hasPromo = post.isHasPromo();
        this.discount = post.getDiscount();
    }

    public Boolean getHasPromo() {
        return hasPromo;
    }

    public void setHasPromo(Boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public static PromoPostOutputDto classToDto(Post post){
        return new PromoPostOutputDto(post);
    }

    @Override
    public int compareTo(Object o) {
        return Long.compare(this.idPost,((PostOutputDto) o).getIdPost());
    }
}

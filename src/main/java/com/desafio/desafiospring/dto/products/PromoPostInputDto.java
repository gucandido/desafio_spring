package com.desafio.desafiospring.dto.products;

import com.desafio.desafiospring.entities.products.Post;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class PromoPostInputDto extends PostInputDto{


    @NotNull
    private Boolean hasPromo;

    @NotNull
    @PositiveOrZero(message = "O desconto não pode ser negativo")
    private BigDecimal discount;

    public PromoPostInputDto() {

    }

    public PromoPostInputDto(Post post) {
        this.userId = post.getUser().getUserId();
        this.idPost = post.getIdPost();
        this.date = post.getDate();
        this.detail = DetailDto.classToDto(post.getDetail());
        this.category = post.getCategory();
        this.price = post.getPrice();
        this.hasPromo = post.isHasPromo();
        this.discount = post.getDiscount();
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

    public static PromoPostInputDto classToDto(Post post){
        return new PromoPostInputDto(post);
    }

}

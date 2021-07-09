package com.desafio.desafiospring.dto.products;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PromoPostDto {

    private long user_id;
    private long id_post;
    private LocalDate date;

    private DetailDto detail;

    private long category;
    private BigDecimal price;

    private boolean hasPromo;
    private BigDecimal discount;

}

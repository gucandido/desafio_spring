package com.desafio.desafiospring.dto.request.products;

import java.math.BigDecimal;
import java.util.Date;

public class PostDto {

    private long user_id;
    private long id_post;
    private Date date;

    private DetailDto detail;

    private long category;
    private BigDecimal price;


}

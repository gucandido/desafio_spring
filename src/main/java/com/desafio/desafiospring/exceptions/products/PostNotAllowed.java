package com.desafio.desafiospring.exceptions.products;

public class PostNotAllowed extends RuntimeException{

    /**
     * Exception que trata quando é feito um post é feito por um buyer
     */
    private static final long serialVersionUID = 11L;

    public PostNotAllowed(String mensagem) {
        super(mensagem);
    }
    public PostNotAllowed(Exception e) {
        super(e);
    }

}

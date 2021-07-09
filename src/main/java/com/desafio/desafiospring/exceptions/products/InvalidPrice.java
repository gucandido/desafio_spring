package com.desafio.desafiospring.exceptions.products;

public class InvalidPrice extends RuntimeException {

    /**
     * Exception que trata quando é feito um post com valor de preço negativo
     */
    private static final long serialVersionUID = 10L;

    public InvalidPrice(String mensagem) {
        super(mensagem);
    }
    public InvalidPrice(Exception e) {
        super(e);
    }

}

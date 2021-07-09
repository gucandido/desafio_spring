package com.desafio.desafiospring.exceptions.products;

public class DetailNotFound extends RuntimeException{

    /**
     * Exception que trata quando um produto não é encontrado
     */
    private static final long serialVersionUID = 12L;

    public DetailNotFound(String mensagem) {
        super(mensagem);
    }
    public DetailNotFound(Exception e) {
        super(e);
    }

}

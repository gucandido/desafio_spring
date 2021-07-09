package com.desafio.desafiospring.exceptions.products;

public class PostNotFound extends RuntimeException{

    /**
     * Exception que trata quando um produto não é encontrado
     */
    private static final long serialVersionUID = 13L;

    public PostNotFound(String mensagem) {
        super(mensagem);
    }
    public PostNotFound(Exception e) {
        super(e);
    }

}

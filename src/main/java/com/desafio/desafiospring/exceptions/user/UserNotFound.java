package com.desafio.desafiospring.exceptions.user;

public class UserNotFound extends RuntimeException{

    /**
     * Exception que trata quando é feito um acesso através de um usuario não cadastrado
     */
    private static final long serialVersionUID = 3L;

    public UserNotFound(String mensagem) {
        super(mensagem);
    }
    public UserNotFound(Exception e) {
        super(e);
    }

}

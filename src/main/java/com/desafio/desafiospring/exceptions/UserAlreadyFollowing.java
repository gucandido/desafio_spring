package com.desafio.desafiospring.exceptions;

public class UserAlreadyFollowing extends RuntimeException{

    /**
     * Exception que trata quando um usuario tenta seguir, porem ele já é um seguidor
     */
    private static final long serialVersionUID = 2L;

    public UserAlreadyFollowing(String mensagem) {
        super(mensagem);
    }
    public UserAlreadyFollowing(Exception e) {
        super(e);
    }

}

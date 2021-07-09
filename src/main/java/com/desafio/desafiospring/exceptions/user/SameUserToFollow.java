package com.desafio.desafiospring.exceptions.user;

public class SameUserToFollow extends RuntimeException{

    /**
     * Exception que trata quando um usuario tenta seguir ele mesmo
     */
    private static final long serialVersionUID = 1L;

    public SameUserToFollow(String mensagem) {
        super(mensagem);
    }
    public SameUserToFollow(Exception e) {
        super(e);
    }

}

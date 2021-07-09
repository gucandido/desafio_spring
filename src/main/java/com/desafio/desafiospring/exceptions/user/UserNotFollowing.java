package com.desafio.desafiospring.exceptions.user;

public class UserNotFollowing extends RuntimeException{

    /**
     * Exception que trata quando é feito um unfollow entre quem já não seguia e nao era seguido
     */
    private static final long serialVersionUID = 5L;

    public UserNotFollowing(String mensagem) {
        super(mensagem);
    }
    public UserNotFollowing(Exception e) {
        super(e);
    }

}

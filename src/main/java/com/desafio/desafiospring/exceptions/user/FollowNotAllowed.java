package com.desafio.desafiospring.exceptions.user;

public class FollowNotAllowed extends RuntimeException{

    /**
     * Exception que trata quando é feito um follow entre tipos não permitidos, por exemplo um seller seguir um buyer
     */
    private static final long serialVersionUID = 4L;

    public FollowNotAllowed(String mensagem) {
        super(mensagem);
    }
    public FollowNotAllowed(Exception e) {
        super(e);
    }

}

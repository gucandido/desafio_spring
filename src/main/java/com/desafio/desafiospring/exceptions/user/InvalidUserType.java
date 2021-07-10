package com.desafio.desafiospring.exceptions.user;

public class InvalidUserType extends RuntimeException{

    /**
     * Exception que trata quando é feito um follow entre tipos não permitidos, por exemplo um seller seguir um buyer
     */
    private static final long serialVersionUID = 6L;

    public InvalidUserType(String mensagem) {
        super(mensagem);
    }
    public InvalidUserType(Exception e) {
        super(e);
    }


}

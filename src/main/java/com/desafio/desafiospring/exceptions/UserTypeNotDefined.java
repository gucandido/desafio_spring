package com.desafio.desafiospring.exceptions;

public class UserTypeNotDefined extends RuntimeException{

    /**
     * Exception que trata quando a criação de um novo usuario recebe um tipo diferente do permitido (buyer ou seller)
     */
    private static final long serialVersionUID = 4L;

    public UserTypeNotDefined(String mensagem) {
        super(mensagem);
    }
    public UserTypeNotDefined(Exception e) {
        super(e);
    }

}

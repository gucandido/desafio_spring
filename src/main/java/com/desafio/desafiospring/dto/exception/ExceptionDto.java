package com.desafio.desafiospring.dto.exception;

public class ExceptionDto {

    private String campo;
    private String mensagem;

    public ExceptionDto() {
    }

    public ExceptionDto(String mensagem) {
        this.mensagem = mensagem;
    }

    public ExceptionDto(String campo, String mensagem){
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

}

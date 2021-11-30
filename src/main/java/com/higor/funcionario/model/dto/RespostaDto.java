package com.higor.funcionario.model.dto;

import java.io.Serializable;

public class RespostaDto implements Serializable {

    private String mensagem;

    public RespostaDto(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}

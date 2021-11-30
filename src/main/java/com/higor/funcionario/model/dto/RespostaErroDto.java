package com.higor.funcionario.model.dto;

import com.higor.funcionario.exception.ICustomException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RespostaErroDto implements Serializable {

    private Integer httpStatusCode;

    private List<RespostaErroDetalheDto> erros;

    public RespostaErroDto(Integer statusCode, List<ICustomException> errors) {
        this.httpStatusCode = statusCode;
        this.erros = new ArrayList<>();

        for (ICustomException ex : errors) {
            this.erros.add(new RespostaErroDetalheDto(ex.getCodigo(), ex.getMensagem()));
        }
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(Integer httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public List<RespostaErroDetalheDto> getErros() {
        return erros;
    }

    public void setErros(List<RespostaErroDetalheDto> erros) {
        this.erros = erros;
    }
}

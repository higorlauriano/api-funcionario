package com.higor.funcionario.exception;

import java.util.ArrayList;
import java.util.List;

public class CustomRuntimeException extends RuntimeException {

    private List<String> errors = new ArrayList<>();

    public CustomRuntimeException(Throwable t) {
        super(t.getMessage(), t);
    }

    public CustomRuntimeException(ICustomException error) {
        super(error.getMensagem());
        this.errors.add(error.getCodigo());
    }

    public CustomRuntimeException(List<ICustomException> errors) {
        super("Dados inválidos");

        for (ICustomException ex : errors) {
            this.errors.add(ex.getCodigo());
        }
    }

    public List<String> getErrors() {
        return errors;
    }


}

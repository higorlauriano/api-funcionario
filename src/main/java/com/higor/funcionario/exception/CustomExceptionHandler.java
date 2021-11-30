package com.higor.funcionario.exception;


import com.higor.funcionario.exception.enums.EnumErrosFuncionario;
import com.higor.funcionario.model.dto.RespostaErroDto;
import com.higor.funcionario.utils.ListUtil;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomRuntimeException.class)
    public ResponseEntity<RespostaErroDto> handleException(CustomRuntimeException ex) {
        return exception(ex);
    }

    private ResponseEntity exception(CustomRuntimeException e) {
        final List<ICustomException> exceptions = new ArrayList<>();

        if (ListUtil.isNotNullOrEmpty(e.getErrors())) {
            for (String errorCode : e.getErrors()) {
                ListUtil.addIfNotNull(exceptions, EnumErrosFuncionario.parseByCodigo(errorCode));
            }
        }

        return ResponseEntity
                .badRequest()
                .contentType(MediaType.APPLICATION_JSON)
                .body(new RespostaErroDto(400, exceptions));
    }

}

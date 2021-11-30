package com.higor.funcionario.validador;

import com.higor.funcionario.exception.CustomRuntimeException;
import com.higor.funcionario.exception.ICustomException;
import com.higor.funcionario.exception.enums.EnumErrosFuncionario;
import com.higor.funcionario.model.entity.Funcionario;
import com.higor.funcionario.utils.ListUtil;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ValidadorFuncionario {

    public void validacoesNovoFuncionario(final Funcionario funcionario) {

        final List<ICustomException> erros = new ArrayList<>();
        ListUtil.addIfNotNull(erros, validarNome(funcionario));
        ListUtil.addIfNotNull(erros, validarSobrenome(funcionario));
        ListUtil.addIfNotNull(erros, validarEmail(funcionario));
        ListUtil.addIfNotNull(erros, validarNIS(funcionario));

        if (!erros.isEmpty()) {
            throw new CustomRuntimeException(erros);
        }
    }

    public EnumErrosFuncionario validarNome(final Funcionario funcionario) {
        final String trimmedNome = StringUtils.trimAllWhitespace(funcionario.getNome());

        if (!StringUtils.hasLength(trimmedNome)
                || trimmedNome.length() < 2
                || trimmedNome.length() > 30) {
            return EnumErrosFuncionario.NOME_INVALIDO;
        }

        return null;
    }

    public EnumErrosFuncionario validarSobrenome(final Funcionario funcionario) {
        final String trimmedSobrenome = StringUtils.trimWhitespace(funcionario.getSobrenome());

        if (!StringUtils.hasLength(trimmedSobrenome)
                || trimmedSobrenome.length() < 2
                || trimmedSobrenome.length() > 50) {
            return EnumErrosFuncionario.SOBRENOME_INVALIDO;
        }

        return null;
    }

    public EnumErrosFuncionario validarEmail(final Funcionario funcionario) {
        final String trimmedEmail = StringUtils.trimAllWhitespace(funcionario.getEmail());

        if (!StringUtils.hasLength(trimmedEmail)) {
            return EnumErrosFuncionario.EMAIL_NAO_INFORMADO;
        }

        return null;
    }

    public EnumErrosFuncionario validarNIS(final Funcionario funcionario) {
        if (!StringUtils.hasLength(funcionario.getNumeroNIS())) {
            return null;
        }

        final boolean possuiCaractereNaoNumerico = StringUtils.hasLength(
                funcionario.getNumeroNIS().replaceAll("[0-9]+", "")
        );

        if (possuiCaractereNaoNumerico) {
            return EnumErrosFuncionario.NIS_INVALIDO;
        }

        return null;
    }

}

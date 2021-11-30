package com.higor.funcionario.exception.enums;

import com.higor.funcionario.exception.ICustomException;

public enum EnumErrosFuncionario implements ICustomException {

    NOME_NAO_INFORMADO("01", "Nome não informado"),
    NOME_INVALIDO("02", "Nome deve conter entre 2 e 30 caracteres"),
    SOBRENOME_INVALIDO("03", "Sobrenome deve conter entre 2 e 50 caracteres"),
    EMAIL_NAO_INFORMADO("04", "Email não informado"),
    FUNCIONARIO_NAO_ENCONTRADO("05", "Funcionario com o ID informado não foi encontrado"),
    NIS_INVALIDO("06", "Número NIS/PIS Inválido, apenas números são permitidos");

    private final String codigo, mensagem;

    EnumErrosFuncionario(String codigo, String mensagem) {
        this.codigo = codigo;
        this.mensagem = mensagem;
    }

    public static EnumErrosFuncionario parseByCodigo(final String key) {
        for (EnumErrosFuncionario en : EnumErrosFuncionario.values()) {
            if (en.getCodigo().equals(key)) {
                return en;
            }
        }
        return null;
    }

    @Override
    public String getCodigo() {
        return this.codigo;
    }

    @Override
    public String getMensagem() {
        return this.mensagem;
    }

}

package com.higor.funcionario.model.dto;

import java.io.Serializable;

public class FuncionarioDto implements Serializable {

    private Integer id;

    private String nome;

    private String sobrenome;

    private String email;

    private String numeroNIS;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroNIS() {
        return numeroNIS;
    }

    public void setNumeroNIS(String numeroNIS) {
        this.numeroNIS = numeroNIS;
    }
}
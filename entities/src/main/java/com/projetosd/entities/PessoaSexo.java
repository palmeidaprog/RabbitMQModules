package com.projetosd.entities;

public enum PessoaSexo {
    MASCULINO('M'),
    FEMININO('F'),
    OUTRO('O');

    private char descricao;

    PessoaSexo(char descricao) {
        this.descricao = descricao;
    }

    public char getDescricao() {
        return descricao;
    }
}

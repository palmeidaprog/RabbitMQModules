package com.projetosd.produceconsume;

public enum Fila {
    BANCO("_banco"),
    EMISSOR("_emissor"),
    ATENDENTE("_atendente");

    Fila(String valor) {
        this.valor = valor;
    }

    String valor;

    public String getValor() {
        return valor;
    }
}

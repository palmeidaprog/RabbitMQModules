package com.projetosd.entities;

import java.io.Serializable;
import java.util.Objects;

public class Endereco implements Serializable {

    private static final long serialVersionUID = -8840111880039611337L;

    private Long id;

    private String rua;

    private String numero;

    private String completemento;

    private String cep;

    private String bairro;

    private String cidade;

    private String estado;

    public Endereco() { }

    public Endereco(String rua, String numero) {
        this.rua = rua;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCompletemento() {
        return completemento;
    }

    public void setCompletemento(String completemento) {
        this.completemento = completemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Endereco)) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(id, endereco.id) &&
                rua.equals(endereco.rua) &&
                numero.equals(endereco.numero) &&
                Objects.equals(completemento, endereco.completemento) &&
                Objects.equals(cep, endereco.cep) &&
                Objects.equals(bairro, endereco.bairro) &&
                Objects.equals(cidade, endereco.cidade) &&
                Objects.equals(estado, endereco.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rua, numero, completemento, cep, bairro,
                cidade, estado);
    }
}

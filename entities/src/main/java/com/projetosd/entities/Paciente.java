package com.projetosd.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Paciente extends Pessoa implements Serializable {

    private static final long serialVersionUID = -925343205139728187L;

    private Endereco endereco;

    private String email;

    private boolean pcd;

    public Paciente() {
        super();
    }

    public Paciente(Integer id, String nome, String sobrenome, Date dataNascimento, String email) {
        super(id, nome, sobrenome, dataNascimento);
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isPcd() {
        return pcd;
    }

    public void setPcd(boolean pcd) {
        this.pcd = pcd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paciente)) return false;
        if (!super.equals(o)) return false;
        Paciente paciente = (Paciente) o;
        return pcd == paciente.pcd &&
                Objects.equals(endereco, paciente.endereco) &&
                Objects.equals(email, paciente.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), endereco, email, pcd);
    }
}

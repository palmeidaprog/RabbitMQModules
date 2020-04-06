package com.projetosd.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 6674616541217996400L;

    private Long id;

    private String nome;

    private String sobrenome;

    private Date dataNascimento;

    private boolean pcd;

    private String cpf;

    private String rg;

    public Pessoa() { }

    public Pessoa(Long id, String nome, String sobrenome, Date dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public boolean isPcd() {
        return pcd;
    }

    public void setPcd(boolean pcd) {
        this.pcd = pcd;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa pessoa = (Pessoa) o;
        return pcd == pessoa.pcd &&
                Objects.equals(id, pessoa.id) &&
                nome.equals(pessoa.nome) &&
                sobrenome.equals(pessoa.sobrenome) &&
                dataNascimento.equals(pessoa.dataNascimento) &&
                Objects.equals(cpf, pessoa.cpf) &&
                Objects.equals(rg, pessoa.rg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, sobrenome, dataNascimento, pcd,
                cpf, rg);
    }
}



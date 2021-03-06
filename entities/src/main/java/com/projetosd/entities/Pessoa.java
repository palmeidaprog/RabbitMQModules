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

    private Integer id;

    private String nome;

    private String sobrenome;

    private Date dataNascimento;

    private String cpf;

    private String rg;

    private PessoaSexo sexo;

    public Pessoa() { }

    public Pessoa(Integer id, String nome, String sobrenome, Date dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
    }

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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public PessoaSexo getSexo() {
        return sexo;
    }

    public void setSexo(PessoaSexo sexo) {
        this.sexo = sexo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id) &&
                nome.equals(pessoa.nome) &&
                sobrenome.equals(pessoa.sobrenome) &&
                dataNascimento.equals(pessoa.dataNascimento) &&
                Objects.equals(cpf, pessoa.cpf) &&
                Objects.equals(rg, pessoa.rg) &&
                sexo == pessoa.sexo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, sobrenome, dataNascimento, cpf, rg, sexo);
    }
}



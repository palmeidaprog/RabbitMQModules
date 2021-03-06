package com.projetosd.datamodule.dataobjects;

import com.projetosd.entities.Pessoa;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public class PessoaDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "sobrenome", nullable = false)
    private String sobrenome;

    @Column(name = "data_nascimento")
    private Date dataNasimento;

    @Column(name = "cpf", columnDefinition = "char(11)")
    private String cpf;

    @Column(name = "rg")
    private String rg;

    @Column(name = "sexo", nullable = false, columnDefinition = "char(1)")
    private Character sexo;

    public PessoaDO() {
    }

    public PessoaDO(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.sobrenome = pessoa.getSobrenome();
        this.dataNasimento = pessoa.getDataNascimento();
        this.cpf = pessoa.getCpf();
        this.rg = pessoa.getRg();
        this.sexo = pessoa.getSexo().getDescricao();
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

    public Date getDataNasimento() {
        return dataNasimento;
    }

    public void setDataNasimento(Date dataNasimento) {
        this.dataNasimento = dataNasimento;
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

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PessoaDO)) return false;
        PessoaDO pessoaDO = (PessoaDO) o;
        return Objects.equals(id, pessoaDO.id) &&
                Objects.equals(nome, pessoaDO.nome) &&
                Objects.equals(sobrenome, pessoaDO.sobrenome) &&
                Objects.equals(dataNasimento, pessoaDO.dataNasimento) &&
                Objects.equals(cpf, pessoaDO.cpf) &&
                Objects.equals(rg, pessoaDO.rg) &&
                Objects.equals(sexo, pessoaDO.sexo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, sobrenome, dataNasimento, cpf,
                rg, sexo);
    }
}

package com.projetosd.datamodule.dataobjects;

import com.projetosd.entities.Agendamento;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "agendamento")
public class AgendamentoDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "atendente_id")
    private AtendenteDO atendente;

    @Column(name = "data_confirmacao")
    private Date dataConfirmacao;

    public AgendamentoDO(Agendamento agendamento) {
        this.id = agendamento.getId();
        this.atendente = agendamento.get;
        this.dataConfirmacao = dataConfirmacao;
    }

    public AgendamentoDO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AgendamentoDO getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(AgendamentoDO agendamento) {
        this.agendamento = agendamento;
    }

    public AtendenteDO getAtendente() {
        return atendente;
    }

    public void setAtendente(AtendenteDO atendente) {
        this.atendente = atendente;
    }

    public Date getDataConfirmacao() {
        return dataConfirmacao;
    }

    public void setDataConfirmacao(Date dataConfirmacao) {
        this.dataConfirmacao = dataConfirmacao;
    }
}

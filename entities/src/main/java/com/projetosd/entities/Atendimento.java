package com.projetosd.entities;

import java.io.Serializable;
import java.util.Date;

public class Atendimento implements Serializable {

    private static final long serialVersionUID = -142887831355955845L;

    private Long id;

    private Agendamento agendamento;

    private Atendente atendente;

    private Date dataConfirmacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    public Date getDataConfirmacao() {
        return dataConfirmacao;
    }

    public void setDataConfirmacao(Date dataConfirmacao) {
        this.dataConfirmacao = dataConfirmacao;
    }
}

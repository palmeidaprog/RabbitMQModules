package com.projetosd.datamodule.dataobjects;


import com.projetosd.entities.Agendamento;
import com.projetosd.entities.Atendimento;

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
import java.util.Objects;

@Entity
@Table(name = "atendimento")
public class AtendimentoDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agendamento_id")
    private AgendamentoDO agendamento;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "atendente_id")
    private AtendenteDO atendente;

    @Column(name = "data_confirmacao")
    private Date dataConfirmacao;

    public AtendimentoDO() {
    }

    public AtendimentoDO(Atendimento atendimento) {
        this.id = null;
        this.agendamento = new AgendamentoDO(atendimento.getAgendamento());
        this.atendente = new AtendenteDO(atendimento.getAtendente());
        this.dataConfirmacao = atendimento.getDataConfirmacao();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AtendimentoDO)) return false;
        AtendimentoDO that = (AtendimentoDO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(agendamento, that.agendamento) &&
                Objects.equals(atendente, that.atendente) &&
                Objects.equals(dataConfirmacao, that.dataConfirmacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, agendamento, atendente, dataConfirmacao);
    }
}


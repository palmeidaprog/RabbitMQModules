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
    @JoinColumn(name = "paciente_id", nullable = false)
    private PacienteDO paciente;

    @Column(name = "data_agendamento")
    private Date dataAgendamento;

    public AgendamentoDO(Agendamento agendamento) {
        this.id = agendamento.getId();
        this.paciente = new PacienteDO(agendamento.getPaciente());
        this.dataAgendamento = agendamento.getDataAgendamento();
    }

    public AgendamentoDO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataConfirmacao) {
        this.dataAgendamento = dataConfirmacao;
    }

    public PacienteDO getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDO paciente) {
        this.paciente = paciente;
    }
}

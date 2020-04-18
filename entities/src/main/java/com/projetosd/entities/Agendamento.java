package com.projetosd.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Agendamento implements Serializable {

    private Long id;

    private static final long serialVersionUID = -127254816531742175L;

    private Paciente paciente;

    private Date dataAgendamento;

    public Agendamento() {
    }

    public Agendamento(Paciente paciente, Date dataAgendamento) {
        this.paciente = paciente;
        this.dataAgendamento = dataAgendamento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Agendamento)) return false;
        Agendamento that = (Agendamento) o;
        return paciente.equals(that.paciente) &&
                dataAgendamento.equals(that.dataAgendamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paciente, dataAgendamento);
    }
}

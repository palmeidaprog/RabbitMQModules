package com.sd.nurseClient.controller;

import com.projetosd.entities.Agendamento;
import com.projetosd.entities.Atendimento;
import com.projetosd.entities.Endereco;
import com.projetosd.entities.Paciente;


import java.util.ArrayList;
import java.util.Date;

public class AgendamentoController {
    private ArrayList<Agendamento> agendamentos;
    private ArrayList<Atendimento> atendimentos;
    public static Agendamento currentAgendamento;

    public AgendamentoController() {
        this.agendamentos = new ArrayList<>();
        this.atendimentos = new ArrayList<>();
        this.loadAgendamentos();
    }

    public Agendamento[] getAgendamentos(){
        return this.agendamentos.toArray(new Agendamento[this.agendamentos.size()]);
    }


    private void loadAgendamentos() {
        Endereco endereco = new Endereco("Caxias", "099");
        endereco.setBairro("Boa Vista");
        endereco.setCep("12012312-20");
        endereco.setCidade("Recife");
        endereco.setCompletemento("N/A");
        endereco.setEstado("PE");
        Paciente paciente = new Paciente(01,"Carlos", "Alberto",
                new Date(), "alberto.carlos@mail.com");
        paciente.setEndereco(endereco);

        Agendamento agendamento = new Agendamento(paciente,new Date());
        this.agendamentos.add(agendamento);
        this.agendamentos.add(agendamento);
        this.agendamentos.add(agendamento);
    }

    public void addone(){
        Endereco endereco = new Endereco("Caxias", "099");
        endereco.setBairro("Boa Vista");
        endereco.setCep("12012312-20");
        endereco.setCidade("Recife");
        endereco.setCompletemento("N/A");
        endereco.setEstado("PE");
        Paciente paciente = new Paciente(01,"Carlos", "Alberto",
                new Date(), "alberto.carlos@mail.com");
        paciente.setEndereco(endereco);

        Agendamento agendamento = new Agendamento(paciente,new Date());
        this.agendamentos.add(agendamento);
    }

    public void agendar(){
        System.out.println("Agendamento para: " + currentAgendamento.getPaciente().getNome());
    }

}

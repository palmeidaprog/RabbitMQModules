package com.sd.nurseClient.controller;

import android.content.Context;
import android.os.AsyncTask;

import com.projetosd.entities.Agendamento;
import com.projetosd.entities.Atendimento;
import com.projetosd.entities.Endereco;
import com.projetosd.entities.Paciente;
import com.projetosd.entities.PessoaSexo;
import com.projetosd.produceconsume.AgendamentoConsumidor;
import com.projetosd.produceconsume.AtendimentoConsumidor;
import com.projetosd.produceconsume.FuncaoProdutor;
import com.projetosd.produceconsume.Produtor;


import java.util.ArrayList;
import java.util.Date;

public class AgendamentoController {
    public static ArrayList<Agendamento> agendamentos = new ArrayList<>();;
    public static Agendamento currentAgendamento;

    public AgendamentoController() {
        this.loadAgendamentos();

    }

    public Agendamento[] getAgendamentos(){
        return this.agendamentos.toArray(new Agendamento[this.agendamentos.size()]);
    }


    private void loadAgendamentos() {

//        Endereco endereco = new Endereco("Caxias", "099");
//        endereco.setBairro("Boa Vista");
//        endereco.setCep("12012312-20");
//        endereco.setCidade("Recife");
//        endereco.setComplemento("N/A");
//        endereco.setEstado("PE");
//        Paciente paciente = new Paciente(01,"Carlos", "Alberto",
//                new Date(), "alberto.carlos@mail.com");
//        paciente.setEndereco(endereco);
//
//        Agendamento agendamento = new Agendamento(paciente,new Date());
//        this.agendamentos.add(agendamento);
//        this.agendamentos.add(agendamento);
//        this.agendamentos.add(agendamento);
    }

    public void addone(){
        Endereco endereco = new Endereco("Caxias", "099");
        endereco.setBairro("Boa Vista");
        endereco.setCep("12012312-20");
        endereco.setCidade("Recife");
        endereco.setComplemento("N/A");
        endereco.setEstado("PE");
        endereco.setId(12);
        Paciente paciente = new Paciente(01,"Carlos", "Alberto",
                new Date(), "alberto.carlos@mail.com");
        paciente.setEndereco(endereco);
        paciente.setSexo(PessoaSexo.MASCULINO);

        Agendamento agendamento = new Agendamento(paciente,new Date());
        this.agendamentos.add(agendamento);
        System.out.println("SIZE ARRAY === " + this.agendamentos.size());
    }

    public void agendar(Context context){
        System.out.println("Agendamento para: " + currentAgendamento.getPaciente().getNome());
        Atendimento atendimento = AtendimentoController.agendamentoToAtendimento(currentAgendamento);
        new CallAPIController().execute(atendimento);
    }

    public static void removeAgendamento(Atendimento atendimento){
        Agendamento agendamentoToRemove = atendimento.getAgendamento();
        AgendamentoController.agendamentos.removeIf(agendamento -> agendamento.getId().equals(agendamentoToRemove.getId()));
    }

}

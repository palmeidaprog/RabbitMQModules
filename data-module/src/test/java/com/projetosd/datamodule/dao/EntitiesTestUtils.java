package com.projetosd.datamodule.dao;

import com.projetosd.entities.Agendamento;
import com.projetosd.entities.Atendente;
import com.projetosd.entities.Atendimento;
import com.projetosd.entities.Endereco;
import com.projetosd.entities.Paciente;
import com.projetosd.entities.PessoaSexo;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class EntitiesTestUtils {

    public static Endereco getEndereco() {
        final Endereco endereco = new Endereco();
        endereco.setBairro("Graças");
        endereco.setCep("52000000");
        endereco.setRua("Av Agamenon");
        endereco.setNumero("200B");
        endereco.setEstado("PE");
        endereco.setCidade("Recife");
        endereco.setComplemento("Apto 1000001");

        return endereco;
    }

    public static Paciente getPaciente() {
        final Paciente paciente = new Paciente();
        paciente.setEndereco(getEndereco());
        paciente.setNome("Paulo");
        paciente.setSobrenome("Almeida");
        paciente.setPcd(true);
        paciente.setCpf("11122233300");
        paciente.setSexo(PessoaSexo.MASCULINO);
        paciente.setEmail("test@gmail.com");

        return paciente;
    }

    public static Agendamento getAgendamento() {
        final Agendamento agendamento = new Agendamento();
        final Date data = new GregorianCalendar(2020, Calendar.MAY,
                1).getTime();
        agendamento.setDataAgendamento(data);
        agendamento.setPaciente(getPaciente());

        return agendamento;
    }

    public static Atendente getAtendente() {
        final Atendente atendente = new Atendente();
        final Date dataNascimento = new GregorianCalendar(1995,
                Calendar.MARCH, 3).getTime();
        atendente.setCodigoCracha("8796d9-ASD-1");
        atendente.setNome("Jorge");
        atendente.setSobrenome("Tavares");
        atendente.setCpf("11122233312");
        atendente.setSexo(PessoaSexo.MASCULINO);
        atendente.setDataNascimento(dataNascimento);

        return atendente;
    }

    public static Atendimento getAtendimento() {
        final Atendimento atendimento = new Atendimento();
        final Date data = new GregorianCalendar(2020,
                Calendar.MAY, 3).getTime();
        atendimento.setDataConfirmacao(data);
        atendimento.setAgendamento(getAgendamento());
        atendimento.setAtendente(getAtendente());

        return atendimento;
    }
}

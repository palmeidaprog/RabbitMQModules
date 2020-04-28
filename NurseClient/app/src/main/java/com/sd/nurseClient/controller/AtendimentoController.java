package com.sd.nurseClient.controller;

import com.projetosd.entities.Agendamento;
import com.projetosd.entities.Atendente;
import com.projetosd.entities.Atendimento;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AtendimentoController {
    public static Atendente currentAtendente = new Atendente();
    public static void createAtentedente(String cracha, String name, String lastname, String cpf,
                                         String rg, String birth, boolean isPcd){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date birthDate = simpleDateFormat.parse(birth);
            currentAtendente.setCodigoCracha(cracha);
            currentAtendente.setNome(name);
            currentAtendente.setSobrenome(lastname);
            currentAtendente.setCpf(cpf);
            currentAtendente.setRg(rg);
            currentAtendente.setDataNascimento(birthDate);
            System.out.println(name);
            System.out.println(currentAtendente);
        } catch (ParseException e) {
            System.out.println("Error Parsing birthDate");
        }
    }
    public static Atendimento agendamentoToAtendimento (Agendamento agendamento){
        Atendimento atendimento = new Atendimento();
        atendimento.setAgendamento(agendamento);
        atendimento.setAtendente(AtendimentoController.currentAtendente);
        atendimento.setDataConfirmacao(new Date());
        return atendimento;
    }
}

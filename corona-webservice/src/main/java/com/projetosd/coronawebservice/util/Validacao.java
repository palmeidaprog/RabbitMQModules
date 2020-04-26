package com.projetosd.coronawebservice.util;

import com.projetosd.coronawebservice.Exception.coronaValidationException;
import com.projetosd.entities.*;
import com.sun.xml.internal.bind.v2.TODO;


public class Validacao {

    public static boolean  validaAtendente(Atendente atendente) throws coronaValidationException {
        if(atendente == null) {
            throw new coronaValidationException("Atendente inválido.");
        }
        if(atendente.getNome().isEmpty()) {
            throw new coronaValidationException("Nome inválido.");
        }
        if(atendente.getSobrenome().isEmpty()) {
            throw new coronaValidationException("SObrenome inválido.");
        }
        //TODO "sexo nao pode ser null"
        return true;
    }

    public static boolean  validaPaciente(Paciente paciente) throws coronaValidationException {
        if(paciente.getNome().isEmpty()) {
            throw new coronaValidationException("Nome inválido.");
        }
        if(paciente.getSobrenome().isEmpty()) {
            throw new coronaValidationException("Sobrenome inválido.");
        }
        validaEndereco(paciente.getEndereco());

        return true;
    }

    public static boolean  validaAtendimento(Atendimento atendimento) {
        return true;
    }

    public static boolean  validaAgendamento(Agendamento agendamento) {
        return true;
    }

    public static boolean  validaEndereco(Endereco endereco) throws coronaValidationException {
        if(endereco == null) {
            throw new coronaValidationException("Endereço não encontrado.");
        }
        if(endereco.getRua().isEmpty()) {
            throw new coronaValidationException("Rua inválida.");
        }
        if(endereco.getNumero().isEmpty()) {
            throw new coronaValidationException("Número do endereço inválido.");
        }
        if(endereco.getCidade().isEmpty()) {
            throw new coronaValidationException(("Cidade não encontrada."));
        }
        return true;
    }

    public static boolean  validaPessoa(Pessoa pessoa) {
        return true;
    }
}

/*
* endereço --> rua numero e cidade(nao pode ser null)       OK
*
* atendente --> nome sobrenome sexo (nao pode ser null)
*
* paciente -->  endereco (testar se pode ser nulo) --> pega o get endereco e valida os dados
*               nome sobrenome sexo , pcd(olhar se é boolean ou Bollean)
*
* agendamento --> paciente , dataAgendamento
*
* atendimento --> agendamento ,atendente , dataConfirmação
*
*
*
* Criar:
*
* toda funcao tem que ter throws e mesnagem bonitinha
*
* excecao coronaValidationException dentro de um pacote Exception dentro do coronawebservices
*
* LOG: intuito para mostrar pra a gente ver o fluxo --> nome da classe, da funcao, se foi bem sucedido e se n foi
*
* */

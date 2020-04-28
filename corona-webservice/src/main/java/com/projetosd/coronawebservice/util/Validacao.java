package com.projetosd.coronawebservice.util;

import com.projetosd.coronawebservice.Exception.CoronaValidationException;
import com.projetosd.entities.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Validacao {

    private static Logger LOGGER = LoggerFactory.getLogger(
            Validacao.class.getName());

    public static boolean  validaAtendente(Atendente atendente) throws CoronaValidationException {
        LOGGER.info("valida :: Validando Atendente");

        if(atendente == null) {
            LOGGER.error("valida :: Atendente inválido porque Atendente não pode ser nulo");
            throw new CoronaValidationException("O Atendente pracisa ser informado.");

        }
        if(atendente.getNome() == null) {
            LOGGER.error("valida :: Atendente inválido porque o nome do Atendente não pode ser nulo");
            throw new CoronaValidationException(" O Nome do atendente precisa ser informado.");
        }
        if(atendente.getSobrenome() == null) {
            LOGGER.error("valida :: Atendente inválido porque o sobrenome do Atendente não pode ser nulo");
            throw new CoronaValidationException("O Sobrenome do atendente precisa ser informado.");
        }
        if(atendente.getSexo() == null) {
            LOGGER.error("valida :: Atendente inválido porque o sexo do Atendente não pode ser nulo");
            throw new CoronaValidationException("O Sexo do atendente precisa ser informado.");
        }

        return true;
    }

    public static boolean  validaPaciente(Paciente paciente) throws CoronaValidationException {
        LOGGER.info("valida :: Validando Paciente");

        if(paciente == null) {
            LOGGER.error("valida :: Paciente inválido porque Paciente não pode ser nulo");
            throw new CoronaValidationException("O paciente precisa ser informado.");
        }
        if(paciente.getNome() == null) {
            LOGGER.error("valida :: Paciente inválido porque o nome do Paciente não pode ser nulo");
            throw new CoronaValidationException("O Nome do paciente precisa ser informado.");
        }
        if(paciente.getSobrenome() == null) {
            LOGGER.error("valida :: Paciente inválido porque o sobrenome do Paciente não pode ser nulo");
            throw new CoronaValidationException("O Sobrenome do paciente precisa ser informado.");
        }
        if(paciente.getSexo() == null) {
            LOGGER.error("valida :: Paciente inválido porque o sexo do Paciente não pode ser nulo");
            throw new CoronaValidationException("O Sexo do paciente precisa ser informado.");
        }
        if(validaEndereco(paciente.getEndereco())){
            return true;
        }

        return true;
    }

    public static boolean  validaAtendimento(Atendimento atendimento) throws CoronaValidationException {
        LOGGER.info("valida :: Validando Atendimento");

        if(atendimento == null) {
            LOGGER.error("valida :: Atendimento inválido porque o Atendimento não pode ser nulo");
            throw new CoronaValidationException("O atendimento precisa ser informado.");
        }

        if(validaAgendamento(atendimento.getAgendamento())) {
            if(validaAtendente(atendimento.getAtendente())) {
                if(atendimento.getDataConfirmacao() == null) {
                    LOGGER.error("valida :: Atendimento inválido porque a data de confirmação do Atendimento não pode ser nulo");
                    throw new CoronaValidationException("A Data de confirmação precisa ser informada.");
                }
            }
        }

        return true;
    }

    public static boolean  validaAgendamento(Agendamento agendamento) throws CoronaValidationException {
        LOGGER.info("valida:: Validando Agendamento");

        if(agendamento == null) {
            LOGGER.error("valida :: Agendamento inválido porque o Agendamento não pode ser nulo");
            throw new CoronaValidationException("O agendamento precisa ser informado.");
        }

        if(validaPaciente(agendamento.getPaciente())){
            if(agendamento.getDataAgendamento() == null) {
                LOGGER.error("valida :: Agendamento inválido porque a data de agendamento do Agendamento não pode ser nulo");
                throw new CoronaValidationException("A data de agendamento precisa ser informada.");
            }
        }

        return true;
    }

    public static boolean  validaEndereco(Endereco endereco) throws CoronaValidationException {
        LOGGER.info("valida :: Validando Endereço");

        if(endereco == null) {
            LOGGER.error("valida :: Endereço inválido porque o Endereço não pode ser nulo");
            throw new CoronaValidationException("O endereço precisa ser informado.");
        }
        if(endereco.getRua() == null) {
            LOGGER.error("valida :: Endereco inválido porque o nome do Endereço não pode ser nulo");
            throw new CoronaValidationException("O Nome da Rua precisa ser informado.");
        }
        if(endereco.getNumero() == null) {
            LOGGER.error("valida :: Endereco inválido porque o número do Endereço não pode ser nulo");
            throw new CoronaValidationException("O Número do endereço precisa ser informado.");
        }
        if(endereco.getCidade() == null) {
            LOGGER.error("valida :: Endereco inválido porque a cidade do Endereço não pode ser nulo");
            throw new CoronaValidationException(("A Cidade precisa ser informada."));
        }

        return true;
    }

}


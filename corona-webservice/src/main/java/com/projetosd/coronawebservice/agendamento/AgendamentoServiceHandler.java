package com.projetosd.coronawebservice.agendamento;

import com.projetosd.coronawebservice.Exception.CoronaValidationException;
import com.projetosd.coronawebservice.util.IdGenerator;
import com.projetosd.coronawebservice.util.Validacao;
import com.projetosd.entities.Agendamento;
import com.projetosd.produceconsume.Produtor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AgendamentoServiceHandler {

    private final static Logger LOGGER = LoggerFactory.getLogger(
            AgendamentoServiceHandler.class.getName());

    private final static Map<Integer, Agendamento> agendamentos;

    static {
        agendamentos = new ConcurrentHashMap<>();
    }

    public void create(Agendamento agendamento) throws CoronaValidationException {
        Validacao.validaAgendamento(agendamento);

        if (agendamento.getId() == null) {
            Integer id = IdGenerator.generateId();
            LOGGER.info("create :: Adicionando id {} ao agendamento", id);
            agendamento.setId(id);
        }

        agendamentos.put(agendamento.getId(),agendamento);


        Produtor produtor = new Produtor();
        produtor.publish(agendamento);
    }

    public static Map<Integer, Agendamento> getAgendamentos() {
        return agendamentos;
    }

}

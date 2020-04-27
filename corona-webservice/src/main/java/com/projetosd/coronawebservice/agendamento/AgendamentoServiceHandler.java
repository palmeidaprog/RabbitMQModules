package com.projetosd.coronawebservice.agendamento;

import com.projetosd.coronawebservice.Exception.CoronaValidationException;
import com.projetosd.coronawebservice.util.IdGenerator;
import com.projetosd.coronawebservice.util.Validacao;
import com.projetosd.entities.Agendamento;
import com.projetosd.produceconsume.Produtor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AgendamentoServiceHandler {

    private static Logger LOGGER = LoggerFactory.getLogger(
            AgendamentoServiceHandler.class.getName());

    public void create(Agendamento agendamento) throws CoronaValidationException {
        Validacao.validaAgendamento(agendamento);

        if (agendamento.getId() == null) {
            Integer id = IdGenerator.generateId();
            LOGGER.info("create :: Adicionando id {} ao agendamento", id);
            agendamento.setId(id);
        }

        Produtor produtor = new Produtor();
        produtor.publish(agendamento);
    }
}

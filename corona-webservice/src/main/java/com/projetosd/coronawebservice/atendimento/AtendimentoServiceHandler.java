package com.projetosd.coronawebservice.atendimento;

import com.projetosd.coronawebservice.Exception.CoronaValidationException;
import com.projetosd.coronawebservice.util.IdGenerator;
import com.projetosd.coronawebservice.util.Validacao;
import com.projetosd.entities.Atendimento;
import com.projetosd.produceconsume.Produtor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AtendimentoServiceHandler {

    private static Logger LOGGER = LoggerFactory.getLogger(AtendimentoServiceHandler.class.getName());

    public void create(Atendimento atendimento) throws CoronaValidationException {
        Validacao.validaAtendimento(atendimento);

        if (atendimento.getId() == null) {
            Integer id = IdGenerator.generateId();
            LOGGER.info("create :: Adicionando id {} ao agendamento", id);
            atendimento.setId(id);
        }

        Produtor produtor = new Produtor();
        produtor.publish(atendimento);
    }
}

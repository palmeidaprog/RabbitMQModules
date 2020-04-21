package com.projetosd.datamodule.dao;

import com.projetosd.datamodule.dataobjects.AgendamentoDO;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AgendamentoDao extends DaoGenerico<AgendamentoDO, Integer> {

    private static Logger LOGGER = LoggerFactory.getLogger(
            AgendamentoDao.class.getName());

    public AgendamentoDao() {
        super(AgendamentoDO.class);
    }

    /**
     * Procura AgendamentoDO por chave primária
     * @param pk chave primaria
     * @return Agendamento (pode retornar null)
     */
    public AgendamentoDO procurar(Integer pk) {
        if (pk != null) {
            LOGGER.error("procurar :: Chave primaria {} nao pode " +
                    "ser nula", pk.getClass().getSimpleName());
        }

        LOGGER.debug("procurar :: Procurando AgendamentoDO com chave" +
                " primaria {} ...", pk);
        final AgendamentoDO agendamentoDO = super.procurar(pk);

        if (pk != null) {
            LOGGER.info("procurar :: AgendamentoDO com chave {} " +
                "encontrado. Objeto: {}", pk, new JSONObject(agendamentoDO)
                    .toString(4));
        }
        return agendamentoDO;
    }

    /**
     * Inserir agendamentoDO
     * @param agendamentoDO  agendamento a ser inserido
     */
    public void inserir(AgendamentoDO agendamentoDO) {
        if (agendamentoDO == null) {
            LOGGER.error("inserir :: AgendamentoDO não pode ser nulo para ser " +
                    "adicionado");
            return;
        }

        LOGGER.debug("inserir :: Adicionando AgendamentoDO ...");
        super.inserir(agendamentoDO);
        LOGGER.info("inserir :: Agendamento adicionado com sucesso. Objeto " +
                "{}", new JSONObject(agendamentoDO).toString(4));
    }
}


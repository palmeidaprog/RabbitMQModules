package com.projetosd.datamodule.dao;

import com.projetosd.datamodule.dataobjects.AgendamentoDO;
import com.projetosd.datamodule.dataobjects.AtendenteDO;
import com.projetosd.datamodule.dataobjects.AtendimentoDO;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AtendimentoDao extends DaoGenerico<AtendimentoDO, Integer> {

    private static Logger LOGGER = LoggerFactory.getLogger(
            AtendimentoDao.class.getName());

    public AtendimentoDao() {
        super(AtendimentoDO.class);
    }

    /**
     * Procura AtendimentoDO por chave primária
     * @param pk chave primaria
     * @return AtendimentoDO (pode retornar null)
     */
    public AtendimentoDO procurar(Integer pk) {
        if (pk != null) {
            LOGGER.error("procurar :: Chave primaria {} nao pode " +
                    "ser nula", pk.getClass().getSimpleName());
        }

        LOGGER.debug("procurar :: Procurando AtendimentoDO com chave" +
                " primaria {} ...", pk);
        final AtendimentoDO atendimentoDO = super.procurar(pk);

        if (pk != null) {
            LOGGER.info("procurar :: AtendimentoDO com chave {} " +
                    "encontrado. Objeto: {}", pk, new JSONObject(atendimentoDO)
                    .toString(4));
        }
        return atendimentoDO;
    }

    /**
     * Inserir atendimentoDO
     * @param atendimentoDO  atendimentoDO a ser inserido
     */
    public void inserir(AtendimentoDO atendimentoDO) {
        if (atendimentoDO == null) {
            LOGGER.error("inserir :: AtendimentoDO não pode ser nulo para ser " +
                    "adicionado");
            return;
        }

        LOGGER.debug("inserir :: Adicionando AtendimentoDO ...");
        super.inserir(atendimentoDO);
        LOGGER.info("inserir :: AtendimentoDO adicionado com sucesso. Objeto " +
                "{}", new JSONObject(atendimentoDO).toString(4));
    }
}

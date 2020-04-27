package com.projetosd.datamodule;

import com.projetosd.datamodule.dao.AgendamentoDao;
import com.projetosd.datamodule.threads.ThreadConsomeAgendamento;
import com.projetosd.datamodule.threads.ThreadConsomeAtendimento;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataModule {

    private final static Logger LOGGER = LoggerFactory.getLogger(
            DataModule.class.getName());


    public void run() {
        final Thread consomeAgendamento = new Thread(
                new ThreadConsomeAgendamento());
        consomeAgendamento.start();
        LOGGER.info("run :: Iniciado thread de consumo do agendamento");

        final Thread consomeAtendimento = new Thread(
                new ThreadConsomeAtendimento());
        consomeAtendimento.start();
        LOGGER.info("run :: Iniciado thread de consumo do atendimento");

        try {
            consomeAgendamento.join();
            consomeAtendimento.join();
        } catch (InterruptedException e) {
            LOGGER.error("run :: Erro ao dar join nas threads. Erro: {}",
                    e.getMessage(), e);
        }
    }
}

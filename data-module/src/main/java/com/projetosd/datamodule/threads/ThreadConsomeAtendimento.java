package com.projetosd.datamodule.threads;

import com.projetosd.datamodule.dao.AgendamentoDao;
import com.projetosd.datamodule.dao.AtendimentoDao;
import com.projetosd.datamodule.dataobjects.AgendamentoDO;
import com.projetosd.datamodule.dataobjects.AtendimentoDO;
import com.projetosd.produceconsume.AgendamentoConsumidor;
import com.projetosd.produceconsume.AtendimentoConsumidor;
import com.projetosd.produceconsume.Fila;

public class ThreadConsomeAtendimento implements Runnable {

    private AtendimentoDao dao;

    public ThreadConsomeAtendimento() {
        this.dao = new AtendimentoDao();
    }

    @Override
    public void run() {
        final AtendimentoConsumidor consumidor = new AtendimentoConsumidor(Fila.BANCO);
        consumidor.run(atendimento -> {
            this.dao.inserir(new AtendimentoDO(atendimento));
        });
    }
}
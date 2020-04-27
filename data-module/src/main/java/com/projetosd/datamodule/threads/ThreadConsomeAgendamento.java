package com.projetosd.datamodule.threads;

import com.projetosd.datamodule.dao.AgendamentoDao;
import com.projetosd.datamodule.dataobjects.AgendamentoDO;
import com.projetosd.produceconsume.AgendamentoConsumidor;

public class ThreadConsomeAgendamento implements Runnable {

    private AgendamentoDao dao;

    public ThreadConsomeAgendamento() {
        this.dao = new AgendamentoDao();
    }

    @Override
    public void run() {
        final AgendamentoConsumidor consumidor = new AgendamentoConsumidor();
        consumidor.run(agendamento -> {
            this.dao.inserir(new AgendamentoDO(agendamento));
        });
    }
}

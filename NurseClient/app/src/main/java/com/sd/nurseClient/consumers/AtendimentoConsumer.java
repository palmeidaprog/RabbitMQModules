package com.sd.nurseClient.consumers;

import android.os.AsyncTask;

import com.projetosd.produceconsume.AgendamentoConsumidor;
import com.projetosd.produceconsume.AtendimentoConsumidor;
import com.sd.nurseClient.controller.AgendamentoController;

public class AtendimentoConsumer extends AsyncTask<String, Void, Integer> {
    @Override
        protected Integer doInBackground(String... objects) {
            final AtendimentoConsumidor consumidor =  new AtendimentoConsumidor();
            consumidor.run(atendimento -> {
                AgendamentoController.removeAgendamento(atendimento);
            });
            return 200;
        }
}

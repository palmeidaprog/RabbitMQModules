package com.sd.nurseClient.consumers;

import android.os.AsyncTask;

import com.projetosd.produceconsume.AgendamentoConsumidor;
import com.sd.nurseClient.controller.AgendamentoController;

public class AgendamentoConsumer extends AsyncTask<String, Void, Integer> {
    @Override
    protected Integer doInBackground(String... objects) {
        final AgendamentoConsumidor consumidor =  new AgendamentoConsumidor();
        consumidor.run(agendamento -> {
            AgendamentoController.agendamentos.add(agendamento);
        });
        return 200;
    }
}

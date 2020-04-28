package com.projetosd.produceconsume;

import org.json.JSONObject;

public class MainConsumer2 {

    public static void main(String[] args) {
        final AgendamentoConsumidor consumidor = new AgendamentoConsumidor(Fila.BANCO);
        consumidor.run(agendamento -> {
            System.out.println("Teste agendamento : ");
            System.out.println(new JSONObject(agendamento).toString(2));
        });
    }
}

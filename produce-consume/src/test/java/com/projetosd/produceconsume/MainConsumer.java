package com.projetosd.produceconsume;

import org.json.JSONObject;

public class MainConsumer {

    public static void main(String[] args) {
        final AtendimentoConsumidor consumidor = new AtendimentoConsumidor(Fila.BANCO);
        consumidor.run(atendimento -> {
            System.out.println("Teste atendimento : ");
            System.out.println(new JSONObject(atendimento).toString(2));
        });
    }
}

package com.projetosd.produceconsume;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class AtendimentoConsumidorTest {

    @Test
    void testConsumidor() {
        final AtendimentoConsumidor consumidor = new AtendimentoConsumidor();
        consumidor.run(atendimento -> {
            System.out.println("Teste atendimento : ");
            System.out.println(new JSONObject(atendimento).toString(2));
        });
    }
}

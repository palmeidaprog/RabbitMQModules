package com.projetosd.produceconsume;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class AgendamentoConsumidorTest {
    @Test
    void testConsumidor() {
        final AgendamentoConsumidor consumidor = new AgendamentoConsumidor();
        consumidor.run(agendamento -> {
            System.out.println("Teste agendamento : ");
            System.out.println(new JSONObject(agendamento).toString(2));
        });
    }
}

package com.projetosd.produceconsume;

import com.projetosd.entities.Agendamento;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ProdutorTest {



    @Test
    void sendAgendamento() {
        Agendamento agendamento = EntitiesTestUtils.getAgendamento();
        Produtor produtor = new Produtor();
        produtor.publish(agendamento);
        produtor.publish(EntitiesTestUtils.getAtendimento());
    }
}

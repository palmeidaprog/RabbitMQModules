package com.projetosd.emissormail;

import com.projetosd.entities.Atendimento;
import com.projetosd.entities.EntitiesTestUtils;
import com.projetosd.produceconsume.Produtor;
import org.junit.jupiter.api.Test;

public class EmissorMailTest {

    @Test
    void enviaAtendimento() {
        final Atendimento atendimento = EntitiesTestUtils.getAtendimento();
        atendimento.getAgendamento().getPaciente().setEmail("pauloalmeidaf@gmail.com");

        final Produtor produtor = new Produtor();
        produtor.publish(atendimento);
    }
}

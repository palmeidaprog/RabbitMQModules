package com.projetosd.datamodule.dao;


import com.projetosd.datamodule.dataobjects.AgendamentoDO;
import com.projetosd.datamodule.dataobjects.EnderecoDO;
import com.projetosd.datamodule.dataobjects.PacienteDO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;

public class AgendamentoDaoTest {

    private EnderecoDO enderecoDO;

    private PacienteDO pacienteDO;

    private AgendamentoDao dao;

    @BeforeEach
    void init() {
        this.dao = new AgendamentoDao();
        pacienteDO = new PacienteDO(EntitiesTestUtils.getPaciente());
    }

    @Test
    void adicionaAgendamento() {
        final AgendamentoDO aInserir = new AgendamentoDO(EntitiesTestUtils
                .getAgendamento());
        this.dao.inserir(aInserir);

        AgendamentoDO agendamentoDO = this.dao.procurar(aInserir.getId());

        PacienteDO pacienteDO = agendamentoDO.getPaciente();
        EnderecoDO enderecoDO = pacienteDO.getEndereco();

        Assertions.assertTrue(aInserir.equals(agendamentoDO), "Objeto " +
            "contido no banco não igual ao inserido");
    }
}

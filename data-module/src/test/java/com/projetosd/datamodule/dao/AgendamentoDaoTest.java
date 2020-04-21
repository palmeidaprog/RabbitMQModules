package com.projetosd.datamodule.dao;


import com.projetosd.datamodule.dataobjects.EnderecoDO;
import com.projetosd.datamodule.dataobjects.PacienteDO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AgendamentoDaoTest {

    private EnderecoDO enderecoDO;

    private PacienteDO pacienteDO;

    private AgendamentoDao dao;

    @BeforeEach
    void init() {
        this.dao = new AgendamentoDao();
        pacienteDO = getPaciente();
    }



    @Test
    void adicionaPacienteDO() {
        this.dao.inserir(getPaciente());
    }
}

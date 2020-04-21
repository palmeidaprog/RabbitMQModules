package com.projetosd.datamodule.dao;


import com.projetosd.datamodule.dataobjects.EnderecoDO;
import com.projetosd.datamodule.dataobjects.PacienteDO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class GenericDaoTest {

    private EnderecoDO enderecoDO;

    private PacienteDO pacienteDO;

    private GenericDao dao;

    @BeforeEach
    void init() {
        this.dao = new GenericDao();
        pacienteDO = getPaciente();
    }

    private EnderecoDO getEndereco() {
        EnderecoDO endereco = new EnderecoDO();
        endereco.setBairro("Graças");
        endereco.setCep(52000000);
        endereco.setRua("Av Agamenon");
        endereco.setNumero("200B");
        endereco.setEstado("PE");
        endereco.setCidade("Recife");
        return endereco;
    }

    private PacienteDO getPaciente() {
        PacienteDO pacienteDO = new PacienteDO();
        pacienteDO.setEndereco(getEndereco());
        pacienteDO.setNome("Paulo");
        pacienteDO.setSobrenome("Almeida");
        pacienteDO.setPcd(true);
        pacienteDO.setCpf("11122233300");
        pacienteDO.setSexo('M');
        return pacienteDO;
    }

    @Test
    void adicionaPacienteDO() {
        this.dao.create(getPaciente());
    }
}

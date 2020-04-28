package com.sd.nurseClient.controller;


import com.projetosd.entities.Agendamento;
import com.projetosd.entities.Atendente;
import com.projetosd.entities.Endereco;
import com.projetosd.entities.Paciente;
import com.sd.nurseClient.model.Address;
import com.sd.nurseClient.model.Patient;

import java.util.ArrayList;
import java.util.Date;

public class PatientController {
    private ArrayList<Patient> patientsForScheduling;
    private ArrayList<Patient> scheduledPatients;

    public PatientController() {
        this.patientsForScheduling = new ArrayList<>();
        this.scheduledPatients = new ArrayList<>();
        this.loadAgendamentos();
    }

    public Patient[] getPatientsForScheduling(){
        return this.patientsForScheduling.toArray(new Patient[this.patientsForScheduling.size()]);
    }


    private void loadAgendamentos() {
        Endereco endereco = new Endereco("Caxias", "099");
        endereco.setBairro("Boa Vista");
        endereco.setCep("12012312-20");
        endereco.setCidade("Recife");
        endereco.setComplemento("N/A");
        endereco.setEstado("PE");
        Paciente paciente = new Paciente(01,"Carlos", "Alberto",
                                            new Date(), "alberto.carlos@mail.com");
        paciente.setEndereco(endereco);

        Agendamento agendamento = new Agendamento(paciente,new Date());


    }

}

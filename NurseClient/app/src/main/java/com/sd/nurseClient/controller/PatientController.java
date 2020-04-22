package com.sd.nurseClient.controller;


import com.projetosd.entities.Atendente;
import com.sd.nurseClient.model.Address;
import com.sd.nurseClient.model.Patient;

import java.util.ArrayList;

public class PatientController {
    private ArrayList<Patient> patientsForScheduling;
    private ArrayList<Patient> scheduledPatients;

    public PatientController() {
        this.patientsForScheduling = new ArrayList<>();
        this.scheduledPatients = new ArrayList<>();
        this.loadPatientsForScheduling();
    }

    public Patient[] getPatientsForScheduling(){
        Atendente atendente = new Atendente();
        return this.patientsForScheduling.toArray(new Patient[this.patientsForScheduling.size()]);
    }


    private void loadPatientsForScheduling(){
        Address address = new Address("Jacinto","07","Santo Amaro","Recife","Pernambuco","52487-999");
        Patient patient1 = new Patient(1,"Teo","Ribeiro", "11/02/2000",address);
        Patient patient2 = new Patient(2,"Medeiros","Zeze", "11/02/2000", address);
        Patient patient3 = new Patient(3,"Maciel","Murilo", "11/02/2000", address);
        Patient patient4 = new Patient(4,"Juca","Jacinto","11/02/2000",address);
        Patient patient5 = new Patient(5,"Josefa","joana", "11/02/2000",address);
        Patient patient6 = new Patient(6,"Medeiros","xiru", "11/02/2000", address);
        Patient patient7 = new Patient(7,"Maciel","marcu", "11/02/2000", address);
        Patient patient8 = new Patient(8,"Juca","roger","11/02/2000",address);
        Patient patient9 = new Patient(9,"Teo","Ribeiro", "11/02/2000",address);
        Patient patient10 = new Patient(10,"Medeiros","Ribeiro", "11/02/2000", address);
        Patient patient11 = new Patient(11,"Maciel","Ribeiro", "11/02/2000", address);
        Patient patient12 = new Patient(12,"Juca","Ribeiro","11/02/2000",address);
        Patient patient13 = new Patient(13,"Teo","Ribeiro", "11/02/2000",address);
        Patient patient14 = new Patient(14,"Medeiros","Ribeiro", "11/02/2000", address);
        Patient patient15 = new Patient(15,"Maciel","Ribeiro", "11/02/2000", address);
        Patient patient16 = new Patient(16,"Juca","Ribeiro","11/02/2000",address);

        Patient [] patient = new Patient [16];
        this.patientsForScheduling.add(patient1);
        this.patientsForScheduling.add(patient2);
        this.patientsForScheduling.add(patient3);
        this.patientsForScheduling.add(patient4);
        this.patientsForScheduling.add(patient5);
        this.patientsForScheduling.add(patient6);
        this.patientsForScheduling.add(patient7);
        this.patientsForScheduling.add(patient8);
        this.patientsForScheduling.add(patient9);
        this.patientsForScheduling.add(patient10);
        this.patientsForScheduling.add(patient11);
        this.patientsForScheduling.add(patient12);
        this.patientsForScheduling.add(patient13);
        this.patientsForScheduling.add(patient14);
        this.patientsForScheduling.add(patient15);
        this.patientsForScheduling.add(patient16);

    }

}

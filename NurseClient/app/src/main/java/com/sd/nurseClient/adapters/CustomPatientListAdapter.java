package com.sd.nurseClient.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.projetosd.entities.Agendamento;
import com.projetosd.entities.Endereco;
import com.projetosd.entities.Paciente;
import com.sd.nurseClient.R;

public class CustomPatientListAdapter extends ArrayAdapter {
    private final Activity context;
    private final Agendamento[] agendamentos;

    public CustomPatientListAdapter (Activity context, Agendamento [] agendamentos){
        super(context, R.layout.listview_row, agendamentos);
        this.context = context;
        this.agendamentos = agendamentos;
    }

    public View getView (int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listview_row, null, true);

        TextView mainText = rowView.findViewById(R.id.mainTextId);
        TextView infoText = rowView.findViewById(R.id.infoTextId);

        Agendamento agendamento = this.agendamentos[position];
        Paciente patient = agendamento.getPaciente();
        Endereco patientAddress = patient.getEndereco();

        mainText.setText(patient.getNome() + " " + patient.getSobrenome());
        StringBuilder info = new StringBuilder(patientAddress.getBairro()).append(" - ")
                .append(patientAddress.getCidade());
        infoText.setText(info.toString());

        return rowView;
    }

    public Agendamento[] getAgendamentos() {
        return this.agendamentos;
    }
}

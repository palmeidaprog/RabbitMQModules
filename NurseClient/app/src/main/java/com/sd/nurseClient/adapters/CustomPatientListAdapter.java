package com.sd.nurseClient.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.sd.nurseClient.R;
import com.sd.nurseClient.model.Address;
import com.sd.nurseClient.model.Patient;

public class CustomPatientListAdapter extends ArrayAdapter {
    private final Activity context;
    private final Patient [] patients;

    public CustomPatientListAdapter (Activity context, Patient [] patients){
        super(context, R.layout.listview_row, patients);
        this.context = context;
        this.patients = patients;
    }

    public View getView (int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listview_row, null, true);

        TextView mainText = rowView.findViewById(R.id.mainTextId);
        TextView infoText = rowView.findViewById(R.id.infoTextId);

        Patient patient = patients[position];
        Address patientAddress = patient.getAddress();

        mainText.setText(patient.getFirstName() + " " + patient.getLastName());
        StringBuilder info = new StringBuilder(patientAddress.getNeighbor()).append(" - ")
                .append(patientAddress.getCity());
        infoText.setText(info.toString());

        return rowView;
    }

    public Patient[] getPatients() {
        return patients;
    }
}

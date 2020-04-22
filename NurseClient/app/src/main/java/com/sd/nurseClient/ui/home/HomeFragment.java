package com.sd.nurseClient.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.sd.nurseClient.R;
import com.sd.nurseClient.activities.ConfirmAttendanceActivity;
import com.sd.nurseClient.adapters.CustomPatientListAdapter;
import com.sd.nurseClient.controller.PatientController;
import com.sd.nurseClient.model.Address;
import com.sd.nurseClient.model.Patient;

public class HomeFragment extends Fragment {

    private PatientController patientController;
    private Patient[] patientsForScheduling;
    private HomeViewModel homeViewModel;
    private ListView listView;
    private TextView casesCounter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

//        ListView patientsList = root.findViewById(R.id.patients);
//        ArrayList<String> patients = homeViewModel.loadTableData();
//        ArrayAdapter arrayAdapter = new ArrayAdapter(root.getContext(),android.R.layout.simple_list_item_1,patients);
//        patientsList.setAdapter(arrayAdapter);
        this.patientController = new PatientController();
        this.patientsForScheduling = this.patientController.getPatientsForScheduling();
        CustomPatientListAdapter patientListAdapter = new CustomPatientListAdapter(this.getActivity(), this.patientsForScheduling);
        this.listView = root.findViewById(R.id.patientsId);
        this.casesCounter = root.findViewById(R.id.tv_opencases_id);

        this.casesCounter.setText("Casos: " + this.patientsForScheduling.length);
        this.listView.setAdapter(patientListAdapter);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ConfirmAttendanceActivity.class);
                CustomPatientListAdapter adapter = (CustomPatientListAdapter) parent.getAdapter();
                Patient patient = adapter.getPatients()[position];
                intent.putExtra("Patient", patient);
                startActivity(intent);
            }
        });
        return root;
    }

    private Patient [] loadPatients (){
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
        patient[0] = patient1;
        patient[1] = patient2;
        patient[2] = patient3;
        patient[3] = patient4;
        patient[4] = patient5;
        patient[5] = patient6;
        patient[6] = patient7;
        patient[7] = patient8;
        patient[8] = patient9;
        patient[9] = patient10;
        patient[10] = patient11;
        patient[11] = patient12;
        patient[12] = patient13;
        patient[13] = patient14;
        patient[14] = patient15;
        patient[15] = patient16;
        return patient;
    }



}

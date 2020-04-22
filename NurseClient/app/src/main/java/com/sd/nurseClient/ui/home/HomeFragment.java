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

import com.projetosd.entities.Agendamento;
import com.sd.nurseClient.R;
import com.sd.nurseClient.activities.ConfirmAttendanceActivity;
import com.sd.nurseClient.adapters.CustomPatientListAdapter;
import com.sd.nurseClient.controller.AgendamentoController;

public class HomeFragment extends Fragment {

    private AgendamentoController agendamentoController;
    private Agendamento[] agendamentos;
    private HomeViewModel homeViewModel;
    private ListView listView;
    private TextView casesCounter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //code commented
        this.agendamentoController = new AgendamentoController();
        this.agendamentos = this.agendamentoController.getAgendamentos();

        CustomPatientListAdapter patientListAdapter = new CustomPatientListAdapter(this.getActivity(), this.agendamentos);
        this.listView = root.findViewById(R.id.patientsId);
        this.casesCounter = root.findViewById(R.id.tv_opencases_id);

        this.casesCounter.setText("Casos: " + this.agendamentos.length);
        this.listView.setAdapter(patientListAdapter);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ConfirmAttendanceActivity.class);
                CustomPatientListAdapter adapter = (CustomPatientListAdapter) parent.getAdapter();
                Agendamento agendamento = adapter.getAgendamentos()[position];
                intent.putExtra("agendamento", agendamento);
                startActivity(intent);
            }
        });
        return root;
    }

}

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

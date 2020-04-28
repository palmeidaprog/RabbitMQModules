package com.sd.nurseClient.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.projetosd.entities.Agendamento;
import com.projetosd.entities.Endereco;
import com.projetosd.entities.Paciente;
import com.sd.nurseClient.R;
import com.sd.nurseClient.controller.AgendamentoController;
import com.sd.nurseClient.controller.AtendimentoController;
import com.sd.nurseClient.model.Address;
import com.sd.nurseClient.model.Patient;

import java.text.SimpleDateFormat;

public class ConfirmAttendanceActivity extends AppCompatActivity {
    private EditText fullnameField;
    private EditText birthField;
    private EditText streetField;
    private EditText numberField;
    private EditText neighborField;
    private EditText cityField;
    private EditText stateField;
    private EditText cepField;
    private EditText attendanceDate;
    private EditText nurseName;
    private Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Confirmar Agendamento");
        setContentView(R.layout.activity_confirm_attendance);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Agendamento agendamento = (Agendamento) getIntent().getSerializableExtra("agendamento");

        this.initFields();
        this.initData(agendamento);
    }

    private void initFields() {
        this.fullnameField  = findViewById(R.id.pt_fullname_id);
        this.birthField     = findViewById(R.id.pt_birth_id);
        this.streetField    = findViewById(R.id.pt_street_id);
        this.numberField    = findViewById(R.id.pt_number_id);
        this.cityField      = findViewById(R.id.pt_city_id);
        this.neighborField  = findViewById(R.id.pt_neighbor_id);
        this.stateField     = findViewById(R.id.pt_state_id);
        this.cepField       = findViewById(R.id.pt_cep_id);
        this.attendanceDate = findViewById(R.id.date_attendance_date_id);
        this.nurseName      = findViewById(R.id.pt_nurse_name_id);
        this.confirmButton  = findViewById(R.id.bt_confirm_attendance_id);
        this.confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AgendamentoController().agendar(ConfirmAttendanceActivity.this);
               // Toast.makeText(ConfirmAttendanceActivity.this, "Agendamento Confirmado!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initData(Agendamento agendamento) {
        Paciente paciente = agendamento.getPaciente();
        Endereco endereco = paciente.getEndereco();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String birthDate =  paciente.getDataNascimento() != null ? formatter.format(paciente.getDataNascimento()) : "";
        String attendanceDate = formatter.format(agendamento.getDataAgendamento());

        this.fullnameField.setText(paciente.getNome() + " " + paciente.getSobrenome());
        this.birthField.setText(birthDate);
        this.streetField.setText(endereco.getRua());
        this.numberField.setText(endereco.getNumero());
        this.neighborField.setText(endereco.getBairro());
        this.cityField.setText(endereco.getCidade());
        this.stateField.setText(endereco.getEstado());
        this.cepField.setText(endereco.getCep());
        this.attendanceDate.setText(attendanceDate);
        this.nurseName.setText(AtendimentoController.currentAtendente.getNome() + " "
                + AtendimentoController.currentAtendente.getSobrenome());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

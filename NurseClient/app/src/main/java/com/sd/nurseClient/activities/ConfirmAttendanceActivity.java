package com.sd.nurseClient.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

import com.sd.nurseClient.R;
import com.sd.nurseClient.model.Address;
import com.sd.nurseClient.model.Patient;

public class ConfirmAttendanceActivity extends AppCompatActivity {
    private EditText fullnameField;
    private EditText birthField;
    private EditText streetField;
    private EditText numberField;
    private EditText neighborField;
    private EditText cityField;
    private EditText stateField;
    private EditText cepField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Confirmar Atendimento");
        setContentView(R.layout.activity_confirm_attendance);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Patient patient = (Patient) getIntent().getSerializableExtra("Patient");

        this.initFields();
        this.initData(patient);
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
    }

    private void initData(Patient patient) {
        Address address = patient.getAddress();
        this.fullnameField.setText(patient.getFirstName() + " " + patient.getLastName());
        this.birthField.setText(patient.getBirth());
        this.streetField.setText(address.getStreet());
        this.numberField.setText(address.getNumber());
        this.neighborField.setText(address.getNeighbor());
        this.cityField.setText(address.getCity());
        this.stateField.setText(address.getState());
        this.cepField.setText(address.getCEP());
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

package com.sd.nurseClient.ui.operator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.projetosd.entities.Atendente;
import com.sd.nurseClient.R;
import com.sd.nurseClient.controller.AtendimentoController;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OperatorFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private Atendente atendente;

    public OperatorFragment(){
        super();
        this.atendente = new Atendente();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_operator, container, false);

        final EditText cracha     = root.findViewById(R.id.pt_badge_id);
        final EditText name       = root.findViewById(R.id.pt_name_id);
        final EditText lastname   = root.findViewById(R.id.pt_lastname_id);
        final EditText cpf        = root.findViewById(R.id.pt_cpf_id);
        final EditText rg         = root.findViewById(R.id.pt_rg_id);
        final EditText birth      = root.findViewById(R.id.pt_birth_id);
        final RadioGroup sex      = root.findViewById(R.id.rg_sex_id);
        final CheckBox isPcd      = root.findViewById(R.id.cb_pcd_id);
        final Button confirmButtom = root.findViewById(R.id.bt_save_id);


        confirmButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AtendimentoController.createAtentedente(
                        cracha.getText().toString(),
                        name.getText().toString(),
                        lastname.getText().toString(),
                        cpf.getText().toString(),
                        rg.getText().toString(),
                        birth.getText().toString(),
                        isPcd.isChecked()
                );
            }
        });

        //Init values
        cracha.setText(AtendimentoController.currentAtendente.getCodigoCracha());
        name.setText(AtendimentoController.currentAtendente.getNome());
        lastname.setText(AtendimentoController.currentAtendente.getSobrenome());
        cpf.setText(AtendimentoController.currentAtendente.getCpf());
        rg.setText(AtendimentoController.currentAtendente.getRg());
        if(AtendimentoController.currentAtendente.getCodigoCracha() != null){
            Date birthDate = AtendimentoController.currentAtendente.getDataNascimento();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String birthText = format.format(birthDate);
            birth.setText(birthText);
        }



        return root;
    }

    private void operator (){

    }
}

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
import com.projetosd.entities.PessoaSexo;
import com.sd.nurseClient.R;
import com.sd.nurseClient.controller.AtendimentoController;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OperatorFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private Atendente atendente;

    private EditText cracha;
    private EditText name;
    private EditText lastname;
    private EditText cpf;
    private EditText rg;
    private EditText birth;
    private RadioGroup sex;
    private CheckBox isPcd;
    private Button confirmButtom;

    public OperatorFragment(){
        super();
        this.atendente = new Atendente();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_operator, container, false);

        this.cracha         = root.findViewById(R.id.pt_badge_id);
        this.name           = root.findViewById(R.id.pt_name_id);
        this.lastname       = root.findViewById(R.id.pt_lastname_id);
        this.cpf            = root.findViewById(R.id.pt_cpf_id);
        this.rg             = root.findViewById(R.id.pt_rg_id);
        this.birth          = root.findViewById(R.id.pt_birth_id);
        this.sex            = root.findViewById(R.id.rg_sex_id);
        this.isPcd          = root.findViewById(R.id.cb_pcd_id);
        this.confirmButtom  = root.findViewById(R.id.bt_save_id);


        confirmButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PessoaSexo sexo = sex.getCheckedRadioButtonId() == R.id.rb_m_id ? PessoaSexo.MASCULINO : PessoaSexo.FEMININO;
                AtendimentoController.createAtentedente(
                        cracha.getText().toString(),
                        name.getText().toString(),
                        lastname.getText().toString(),
                        cpf.getText().toString(),
                        rg.getText().toString(),
                        birth.getText().toString(),
                        isPcd.isChecked(),
                        sexo
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
        if(AtendimentoController.currentAtendente.getCodigoCracha() == null){
            this.loadOperator();
        }
        return root;
    }

    private void loadOperator (){
        this.cracha.setText("00001");
        this.name.setText("Maria");
        this.lastname.setText("Carmo");
        this.cpf.setText("08798765428");
        this.rg.setText("187987456");
        this.birth.setText("02/08/1990");
        this.sex.check(R.id.rb_f_id);
    }
}

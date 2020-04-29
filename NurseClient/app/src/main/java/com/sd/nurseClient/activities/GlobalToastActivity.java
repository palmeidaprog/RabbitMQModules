package com.sd.nurseClient.activities;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GlobalToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Handler handler = new Handler(Looper.getMainLooper());

        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), "Agendamento sygdyasgydgaygsydgaysgdygsa!", Toast.LENGTH_LONG).show();
            }
        });

    }
}

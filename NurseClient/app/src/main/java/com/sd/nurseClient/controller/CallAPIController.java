package com.sd.nurseClient.controller;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projetosd.entities.Atendimento;
import com.sd.nurseClient.activities.GlobalToastActivity;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class CallAPIController extends AsyncTask<Atendimento, String, String> {

    public CallAPIController(){
        //set context variables if required
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Atendimento... params) {
        String urlString ="http://192.168.25.180:8080/atendimento/create"; // URL to call
        Atendimento atendimento = params[0]; //data to post
        OutputStream out = null;
        atendimento.getAgendamento().setId(12);
        atendimento.setId(13);

        try {
            ObjectMapper Obj = new ObjectMapper();
            Obj.setDateFormat(new SimpleDateFormat(
                    "EEE MMM dd HH:mm:ss zzz yyyy", Locale.US));
            String data = Obj.writeValueAsString(atendimento);

            System.out.println(data);

            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "text/plain; utf-8");
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setDoOutput(true);


            out = new BufferedOutputStream(urlConnection.getOutputStream());

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
            writer.write(data);
            writer.flush();
            System.out.println(urlConnection.getResponseCode());

            writer.close();
            out.close();

            urlConnection.connect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "ok";
    }
}
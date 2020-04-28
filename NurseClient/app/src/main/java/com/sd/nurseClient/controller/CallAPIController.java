package com.sd.nurseClient.controller;

import android.os.AsyncTask;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projetosd.entities.Atendimento;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

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
        String urlString ="http://192.168.25.184:8080/atendimento/create"; // URL to call
        Atendimento atendimento = params[0]; //data to post
        OutputStream out = null;

        try {
            ObjectMapper Obj = new ObjectMapper();
            String data = Obj.writeValueAsString(atendimento);

            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json; utf-8");
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setDoOutput(true);


            out = new BufferedOutputStream(urlConnection.getOutputStream());

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
            writer.write(data);
            writer.flush();
            writer.close();
            out.close();

            urlConnection.connect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "ok";
    }
}
package com.example.syl.travel.ui;


import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.syl.travel.R;
import com.example.syl.travel.service.Contributor;
import com.example.syl.travel.service.ServerService;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public class RegisterActivity extends AppCompatActivity {

    //create Retrofit instance
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://210.100.238.118:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //view
        final EditText emailText = (EditText) findViewById(R.id.emailText);
        final EditText passwordText = (EditText) findViewById(R.id.passwordText);
        final EditText nameText = (EditText) findViewById(R.id.nameText);

        //buttonListener
        Button registerButton = (Button) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = emailText.getText().toString();
                String password = passwordText.getText().toString();
                String name = nameText.getText().toString();

                final ServerService serverService = retrofit.create(ServerService.class);

                Call<ResponseBody> call = serverService.registerUser(
                      email, password, name
                );

                new NetworkCall().execute(call);

                System.out.println("Success");

                /*call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Toast.makeText(RegisterActivity.this, "success", Toast.LENGTH_SHORT).show();
                        try {
                            Log.v("Test", response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (response.isSuccessful()) {
                            System.out.println("Success2");
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(RegisterActivity.this, "error :(", Toast.LENGTH_SHORT).show();
                    }
                });*/
            }
        });
    }
    private class NetworkCall extends AsyncTask<Call, Void, String> {

        @Override
        protected String doInBackground(Call[] calls) {
            try {
                Call<ResponseBody> call = calls[0];
                Response<ResponseBody> response = call.execute();
                return response.body().toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {

        }
    }
}



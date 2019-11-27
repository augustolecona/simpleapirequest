package com.example.tinderlike;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tinderlike.models.Example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview=(TextView) findViewById(R.id.text);
        getdata();
    }

public void getdata(){
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    ApiInterface apiIn = retrofit.create(ApiInterface.class);
    Call<Example> call =  apiIn.getUser();
    call.enqueue(new Callback<Example>() {
        @Override
        public void onResponse(Call<Example> call, Response<Example> response) {
            if (!response.isSuccessful()) {
                Toast.makeText(getApplicationContext(), Integer.toString(response.code()), Toast.LENGTH_LONG).show();
                return;
            }
                Example example= response.body();
                textview.setText(example.toString());
        }

        @Override
        public void onFailure(Call<Example> call, Throwable t) {


        }
    });

}
}

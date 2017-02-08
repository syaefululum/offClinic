package com.example.posmedicine;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.posmedicine.Adapter.AppointmentAdapter;
import com.example.posmedicine.models.response.AppointmentResponse;
import com.example.posmedicine.network.ApiService;
import com.example.posmedicine.network.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppointmentActivity extends AppCompatActivity {

    ApiService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent v = new Intent(AppointmentActivity.this,AppointmentDetailActivity.class);
                AppointmentActivity.this.startActivity(v);
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

        service = RestClient.getInstance().getApiService();
        getAppointment();
        Typeface iconFont = FontManager.getTypeface(getApplicationContext(), FontManager.FONTAWESOME);
        FontManager.markAsIconContainer(findViewById(R.id.activity_appointment), iconFont);
    }

    public void getAppointment(){
        service.getAppointmentbyDoctor(1).enqueue(new Callback<AppointmentResponse>() {
            @Override
            public void onResponse(Call<AppointmentResponse> call, Response<AppointmentResponse> response) {
                LinearLayoutManager llm = new LinearLayoutManager(AppointmentActivity.this);
                llm.setOrientation(LinearLayoutManager.VERTICAL);

                AppointmentAdapter appointmentAdapter = new AppointmentAdapter(response.body().getAppointment(),AppointmentActivity.this);
                RecyclerView rvAppointment = (RecyclerView)findViewById(R.id.rvAppointment);
                rvAppointment.setLayoutManager(llm);
                rvAppointment.setAdapter(appointmentAdapter);
            }

            @Override
            public void onFailure(Call<AppointmentResponse> call, Throwable t) {

            }
        });
    }

}

package com.example.posmedicine;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.posmedicine.Adapter.MedicineAdapter;
import com.example.posmedicine.models.response.MedicineResponse;
import com.example.posmedicine.network.ApiService;
import com.example.posmedicine.network.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MedicineActivity extends AppCompatActivity {

    ApiService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        service = RestClient.getInstance().getApiService();
        getMedicine();
    }

    public void getMedicine(){
       service.getMedicine().enqueue(new Callback<MedicineResponse>() {
           @Override
           public void onResponse(Call<MedicineResponse> call, Response<MedicineResponse> response) {
               LinearLayoutManager llm = new LinearLayoutManager(MedicineActivity.this);
               llm.setOrientation(LinearLayoutManager.VERTICAL);

               MedicineAdapter medicineAdapter = new MedicineAdapter(response.body().getMedicine(),MedicineActivity.this);
               RecyclerView rvMedicine = (RecyclerView)findViewById(R.id.rvMedicine);
               rvMedicine.setLayoutManager(llm);
               rvMedicine.setAdapter(medicineAdapter);
           }

           @Override
           public void onFailure(Call<MedicineResponse> call, Throwable t) {

           }
       });
    }
}

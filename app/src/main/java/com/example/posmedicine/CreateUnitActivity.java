package com.example.posmedicine;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.posmedicine.model.response.UnitResponse;
import com.example.posmedicine.network.ApiService;
import com.example.posmedicine.network.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateUnitActivity extends AppCompatActivity {
    Button bCreateUnit, bCancel;
    EditText editTextUnitName;
    ApiService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_unit);

        bCreateUnit = (Button)findViewById(R.id.bCreateUnit);
        bCancel = (Button)findViewById(R.id.bCancel);
        editTextUnitName = (EditText)findViewById(R.id.editTextUnitName);

        service = RestClient.getInstance().getApiService();

        bCreateUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String unitName = editTextUnitName.getText().toString().trim();
                if(unitName.isEmpty() || unitName.length() == 0 || unitName.equals("") || unitName == null){
                    Snackbar.make(v, "Please input unit name", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }else{
                    createNewUnit(unitName);
                }
            }
        });

        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }

    public void createNewUnit(String unitName){

        service.createUnit(unitName).enqueue(new Callback<UnitResponse>() {
            @Override
            public void onResponse(Call<UnitResponse> call, Response<UnitResponse> response) {
                Intent mainActivity = new Intent(CreateUnitActivity.this,MainActivity.class);
                CreateUnitActivity.this.startActivity(mainActivity);
                finish();
            }

            @Override
            public void onFailure(Call<UnitResponse> call, Throwable t) {
                finish();
            }
        });
    }
}

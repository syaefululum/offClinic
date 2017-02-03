package com.example.posmedicine.Adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.posmedicine.EditUnitActivity;
import com.example.posmedicine.MainActivity;
import com.example.posmedicine.R;
import com.example.posmedicine.interfaces.UnitActions;
import com.example.posmedicine.model.Unit;
import com.example.posmedicine.model.response.UnitResponse;
import com.example.posmedicine.network.ApiService;
import com.example.posmedicine.network.RestClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Syaeful_U1438 on 01/27/17.
 */

public class UnitAdapter extends RecyclerView.Adapter<UnitAdapter.ViewHolder> {
    private List<Unit> unit;
    private MainActivity activity;

    public UnitAdapter(List<Unit> unit, MainActivity activity) {
        this.unit = unit;
        this.activity = activity;
    }

    @Override
    public UnitAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(UnitAdapter.ViewHolder holder, final int position) {
        //holder.textView.setText(unit.get(position).getName());
        Log.d("Unitfdsfsf", unit.get(position).toString());
        holder.unitName.setText(unit.get(position).getName());
        holder.cvUnit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d("Unit", unit.get(position).toString());
                Bundle extras = new Bundle();
                extras.putInt("id", unit.get(position).getId());
                extras.putString("unitName", unit.get(position).getName());
                extras.putParcelable("interface",activity);

                Intent editUnit = new Intent(v.getContext(), EditUnitActivity.class);
                editUnit.putExtras(extras);
                v.getContext().startActivity(editUnit);
            }
        });

        holder.bDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int unitId = unit.get(position).getId();
                deleteUnit(unitId);
                activity.getUnit();
            }
        });
    }

    public void deleteUnit(int unitId){
        ApiService service;
        service = RestClient.getInstance().getApiService();
        service.deleteUnit(unitId).enqueue(new Callback<UnitResponse>() {
            @Override
            public void onResponse(Call<UnitResponse> call, Response<UnitResponse> response) {

            }

            @Override
            public void onFailure(Call<UnitResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return unit.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView textView;
        public CardView cvUnit;
        public TextView unitName;
        public ImageView bDelete;
        public ViewHolder(View v){
            super(v);
            cvUnit = (CardView)v.findViewById(R.id.categoryUnit);
            unitName = (TextView)v.findViewById(R.id.category_name);
            bDelete = (ImageView) v.findViewById(R.id.bDeleteUnit);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                }
            });
            textView = (TextView) v.findViewById(R.id.textView);
        }

        public TextView getTextView() {
            return textView;
        }
    }
}

package com.example.posmedicine.Adapter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.posmedicine.MedicineActivity;
import com.example.posmedicine.R;
import com.example.posmedicine.model.Medicine;
import com.example.posmedicine.model.Unit;

import java.util.List;

/**
 * Created by Syaeful_U1438 on 02-Feb-17.
 */

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.ViewHolder> {
    private List<Medicine> medicine;
    private List<Unit> unit;
    private MedicineActivity activity;

    public MedicineAdapter(List<Medicine> medicine, MedicineActivity activity){
        this.medicine = medicine;
        this.activity = activity;
    }

    @Override
    public MedicineAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row_medicine, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MedicineAdapter.ViewHolder holder, final int position) {
        Log.d("Unitfdsfsf", medicine.get(position).toString());
        holder.medicineName.setText(medicine.get(position).getName());
        holder.medicineType.setText(medicine.get(position).getType());
        holder.medicineStock.setText(medicine.get(position).getQuantity());
        holder.medicinePrice.setText(medicine.get(position).getPrice());


//                unit.get(medicine.get(position).getUnitId()).;

        holder.cvMedicine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Bundle extras = new Bundle();
                extras.putInt("idMedicine", medicine.get(position).getId());
                extras.putString("medicineName", medicine.get(position).getName());
                extras.putParcelable("interface", (Parcelable) activity);

//                Intent editUnit = new Intent(v.getContext(), EditUnitActivity.class);
//                editUnit.putExtras(extras);
//                v.getContext().startActivity(editUnit);
            }
        });
    }

    @Override
    public int getItemCount() {
        return medicine.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
       // private final TextView textView;
        public CardView cvMedicine;
        public TextView medicineName;
        public TextView medicineType;
        public TextView medicineStock;
        public TextView medicinePrice;
        public ViewHolder(View v) {
            super(v);
            cvMedicine = (CardView)v.findViewById(R.id.categoryMedicine);
            medicineName = (TextView)v.findViewById(R.id.medicine_name);
            medicineType = (TextView)v.findViewById(R.id.medicine_type);
            medicineStock = (TextView)v.findViewById(R.id.medicine_stock);
            medicinePrice = (TextView)v.findViewById(R.id.medicine_price);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                }
            });
            //textView = (TextView) v.findViewById(R.id.textView);
        }
    }
}

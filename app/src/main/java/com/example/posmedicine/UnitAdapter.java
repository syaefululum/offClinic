package com.example.posmedicine;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.posmedicine.models.Unit;

import java.util.List;

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
        holder.unitName.setText(unit.get(position).getName());
        holder.cvUnit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast toast = Toast.makeText(v.getContext(), unit.get(position).getName(),Toast.LENGTH_SHORT);
                toast.show();
//                Intent createUnit = new Intent(MainActivity.this,CreateUnitActivity.class);
//                MainActivity.this.startActivity(createUnit);
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
        public ViewHolder(View v){
            super(v);
            cvUnit = (CardView)v.findViewById(R.id.categoryUnit);
            unitName = (TextView)v.findViewById(R.id.category_name);
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

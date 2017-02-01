package com.example.posmedicine.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v7.widget.CardView;

import com.example.posmedicine.MainActivity;
import com.example.posmedicine.R;
import com.example.posmedicine.models.Unit;

import java.util.List;

/**
 * Created by Syaeful_U1438 on 30-Jan-17.
 */

public class UnitsAdapter extends RecyclerView.Adapter<UnitsAdapter.ViewHolder> {
    private MainActivity activity;
    private List<Unit> units;

    public UnitsAdapter(List<Unit> units, MainActivity activity){
        this.units = units;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_item, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Unit unit = units.get(position);
        holder.unitName.setText(unit.getName());
    }

    @Override
    public int getItemCount() {
        return units.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView cvUnit;
        TextView unitName;

        public ViewHolder(View v){
            super(v);
            cvUnit = (CardView) v.findViewById(R.id.categoryUnit);
            unitName = (TextView) v.findViewById(R.id.unit_category);
        }
    }
}

package com.example.posmedicine.model.response;

/**
 * Created by Syaeful_U1438 on 01/27/17.
 */

import java.util.List;

import com.example.posmedicine.model.Unit;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UnitResponse {

    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("data")
    @Expose
    private List<Unit> unit = null;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Unit> getUnit() {
        return unit;
    }

    public void setUnit(List<Unit> unit) {
        this.unit = unit;
    }

}

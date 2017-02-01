package com.example.posmedicine.models.response;

/**
 * Created by Surya_N2267 on 2/1/2017.
 */

import com.example.posmedicine.models.Doctor;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DoctorResponse {
    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("data")
    @Expose
    private List<Doctor> doctors = null;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Doctor> getData() {
        return doctors;
    }

    public void setData(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}

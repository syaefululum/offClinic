package com.example.posmedicine.models.response;

/**
 * Created by Surya_N2267 on 2/6/2017.
 */

import java.util.List;

import com.example.posmedicine.models.Doctor;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DoctorResponse {

    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("data")
    @Expose
    private List<Doctor> doctor = null;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Doctor> getDoctor() {
        return doctor;
    }

    public void setDoctor(List<Doctor> doctor) {
        this.doctor = doctor;
    }
}

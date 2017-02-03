package com.example.posmedicine.network;

import com.example.posmedicine.model.Unit;
import com.example.posmedicine.model.response.MedicineResponse;
import com.example.posmedicine.model.response.UnitResponse;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Syaeful_U1438 on 01/27/17.
 */

public interface ApiService {
    @GET("/clinic/web/v1/unit")
    Call<UnitResponse> getUnits();

    @FormUrlEncoded
    @GET("/clinic/web/v1/unit/view")
    Call<UnitResponse> getUnitById(
            @Query("id") int id
    );

    @FormUrlEncoded
    @POST("/clinic/web/v1/unit/create")
    Call<UnitResponse> createUnit(
            @Field("name") String name
    );

    @FormUrlEncoded
    @PUT("/clinic/web/v1/unit/update")
    Call<UnitResponse> updateUnit(
            @Query("id") int id,
            @Field("name") String name
    );

    @DELETE("/clinic/web/v1/unit/delete")
    Call<UnitResponse> deleteUnit(
            @Query("id") int id
    );

    @GET("/clinic/web/v1/medicine")
    Call<MedicineResponse> getMedicine();
}

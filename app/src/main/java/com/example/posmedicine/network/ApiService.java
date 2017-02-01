package com.example.posmedicine.network;

import com.example.posmedicine.models.response.UnitResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Syaeful_U1438 on 01/27/17.
 */

public interface ApiService {
    /**
     * Unit
     */
    @GET("/clinic/web/v1/unit")
    Call<UnitResponse> getUnits();

    @FormUrlEncoded
    @GET("/clinic/web/v1/unit/view")
    Call<UnitResponse> getUnitById(
            @Path("id") int id
    );

    @FormUrlEncoded
    @POST("/clinic/web/v1/unit/create")
    Call<UnitResponse> createUnit(
            @Field("name") String name
    );

    /**
     * Doctor
     */
    @GET("/clinic/web/v1/doctor")
    Call<UnitResponse> getDoctors();

    /**
     * Person
     */
    @GET("/clinic/web/v1/person")
    Call<UnitResponse> getPersons();
}

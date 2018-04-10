package com.example.syl.travel.service;

import org.json.JSONObject;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by SYL on 2018-03-25.
 */

public interface ServerService {

    @GET("/signin")
    //json Array를 리턴해야해서 List
    Call<List<Contributor>> contributors(
            @Path("email") String email,
            @Path("password") String password
    );

    @FormUrlEncoded
    @POST("/signup")
    Call<ResponseBody> registerUser(
            @Field("email") String email,
            @Field("password") String password,
            @Field("username") String username
    );
}


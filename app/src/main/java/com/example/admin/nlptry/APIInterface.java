package com.example.admin.nlptry;

import com.example.admin.nlptry.MultipleResource;
import com.example.admin.nlptry.User;
import com.example.admin.nlptry.UserList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface
{
    @GET("home")
    Call<List<Post>> Get();


}

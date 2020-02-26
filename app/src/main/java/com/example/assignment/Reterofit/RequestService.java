package com.example.assignment.Reterofit;

import com.example.assignment.Models.Model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestService {

    @GET("search?q=title:DNA")
    Call<Model> requestGet();
}

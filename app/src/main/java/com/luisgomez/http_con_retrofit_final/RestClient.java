package com.luisgomez.http_con_retrofit_final;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface RestClient {
    @GET("posts")
    Call<List<Post>> getObtenerPost();
}

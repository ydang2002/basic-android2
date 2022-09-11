package com.nhuy.useretrofitcallapi.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nhuy.useretrofitcallapi.model.Currency;
import com.nhuy.useretrofitcallapi.model.Post;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    //Link API: http://apilayer.net/api/live?access_key=843d4d34ae72b3882e3db642c51e28e6&currencies=VND&source=USD&format=1
    //https://jsonplaceholder.typicode.com/posts
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    // Initialize Retrofit
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    //Call API
    @GET("api/live")
    Call<Currency> convertUsdVnd(@Query("access_key") String access_key,
                                 @Query("currencies") String currencies,
                                 @Query("source") String source,
                                 @Query("format") int format);

    //Call API
    @GET("api/live?access_key=843d4d34ae72b3882e3db642c51e28e6&currencies=VND&source=USD&format=1")
    Call<Currency> convertUsdVnd1();

    @POST("posts")
    Call<Post> sendPosts(@Body Post post);
}

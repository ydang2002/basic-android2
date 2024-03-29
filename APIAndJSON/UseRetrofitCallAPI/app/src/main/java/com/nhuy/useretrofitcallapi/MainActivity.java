package com.nhuy.useretrofitcallapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.nhuy.useretrofitcallapi.api.ApiService;
import com.nhuy.useretrofitcallapi.model.Currency;
import com.nhuy.useretrofitcallapi.model.Post;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView tvTerms;
    private TextView tvSource;
    private TextView tvUsdVnd;
    private Button btnCallApi;
    private TextView tvPostResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTerms = findViewById(R.id.tv_terms);
        tvSource = findViewById(R.id.tv_source);
        tvUsdVnd = findViewById(R.id.tv_usd_vnd);
        btnCallApi = findViewById(R.id.btn_call_api);
        tvPostResult = findViewById(R.id.tv_id_post_result);

        btnCallApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // clickCallApi();
                sendPosts();
            }
        });
    }

    //Link API: http://apilayer.net/api/live?access_key=843d4d34ae72b3882e3db642c51e28e6&currencies=VND&source=USD&format=1
    private void clickCallApi() {
//        ApiService.apiService.convertUsdVnd("843d4d34ae72b3882e3db642c51e28e6",
//                "VND", "USD", 1).enqueue(new Callback<Currency>() {
        ApiService.apiService.convertUsdVnd1().enqueue(new Callback<Currency>() {
             // Trả về dữ liệu nếu như Call Api thành công
            @Override
            public void onResponse(Call<Currency> call, Response<Currency> response) {
                Toast.makeText(MainActivity.this, "Call Api success", Toast.LENGTH_SHORT).show();
                Currency currency = response.body();
                if(currency != null && currency.isSuccess()){
                    tvTerms.setText(currency.getTerms());
                    tvSource.setText(currency.getSource());
                    tvUsdVnd.setText(String.valueOf(currency.getQuotes().getUsdVnd()));

                }
            }

            @Override
            public void onFailure(Call<Currency> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Call Api Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sendPosts() {
        Post post = new Post(10, 101, "Nhu Y", "Nhu Y 123");

        ApiService.apiService.sendPosts(post).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Toast.makeText(MainActivity.this, "Call Api success", Toast.LENGTH_SHORT).show();

                Post postResult = response.body();
                if(postResult != null) {
                    tvPostResult.setText(postResult.toString());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Call Api Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
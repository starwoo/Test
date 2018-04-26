package com.star.pt.retrofit;

import android.util.Log;

import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.star.pt.bean.Book;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 吴世达 on 2018/4/26.
 */

public class RetrofitExcutor {
    public static void exc(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(UrlConfig.BASE_URL).addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create())).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        RetrofitService service = retrofit.create(RetrofitService.class);
        Call<Book> call = service.getSearchBook("金瓶梅", null, 0, 1);
        call.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                Log.i("resp",response.body().toString());
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {

            }
        });
    }
}

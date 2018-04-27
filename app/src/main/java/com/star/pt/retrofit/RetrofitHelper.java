package com.star.pt.retrofit;

import android.content.Context;

import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 吴世达 on 2018/4/26.
 */

public class RetrofitHelper {
    private Context mContext;
    private Retrofit mRetrofit;
    private static RetrofitHelper helper=null;
    private RetrofitHelper(Context context){
        this.mContext = context;
        init();
    }
    public static RetrofitHelper getInstance(Context context){
        if(helper==null){
            helper = new RetrofitHelper(context);
        }
        return helper;
    }

    private void init(){
        mRetrofit = new Retrofit.Builder()
                .baseUrl(UrlConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public RetrofitService getRetrofitService(){
        return mRetrofit.create(RetrofitService.class);
    }

    public static void exc(){
//        Retrofit retrofit = new Retrofit.Builder().baseUrl(UrlConfig.BASE_URL)
////                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        RetrofitService service = retrofit.create(RetrofitService.class);
//        Call<ResponseBody> call = service.getSearchBook("金瓶梅", null, 0, 1);
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                try {
//                    Log.i("jjjjjjjjj",new String(response.body().bytes()));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//            }
//        });
    }
}

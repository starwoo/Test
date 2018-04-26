package com.star.pt.retrofit;

import android.content.Context;
import android.util.Log;

import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.star.pt.retrofit.bean.Book;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
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
        Retrofit retrofit = new Retrofit.Builder().baseUrl(UrlConfig.BASE_URL).addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create())).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        RetrofitService service = retrofit.create(RetrofitService.class);
        Observable<Book> observable = service.getSearchBook("金瓶梅", null, 0, 1);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Book>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Book value) {
                        Log.i("jjjjjjjjj",value.toString());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

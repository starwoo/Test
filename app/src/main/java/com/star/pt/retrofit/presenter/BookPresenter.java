package com.star.pt.retrofit.presenter;

import android.content.Context;
import android.content.Intent;

import com.star.pt.retrofit.manager.DataManager;
import com.star.pt.retrofit.view.View;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.internal.subscriptions.ArrayCompositeSubscription;

/**
 * Created by 吴世达 on 2018/4/26.
 */

public class BookPresenter implements Presenter {
    private Context mContext;
    private DataManager dataManager;

    public BookPresenter(Context context){
        this.mContext = context;
    }

    @Override
    public void onCreate() {
        dataManager = new DataManager(mContext);
        ArrayCompositeSubscription mm=new ArrayCompositeSubscription();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void attachView(View view) {

    }

    @Override
    public void attachIncomingIntent(Intent intent) {

    }

    public void getSearchBook(String name,String tag,Integer start,Integer count){
        dataManager
    }
}

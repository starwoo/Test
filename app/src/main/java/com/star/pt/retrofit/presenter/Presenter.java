package com.star.pt.retrofit.presenter;

import android.content.Intent;

import com.star.pt.retrofit.view.View;

/**
 * Created by 吴世达 on 2018/4/26.
 */

public interface Presenter {
    void onCreate();

    void onStart();//暂时没用到

    void onStop();

    void pause();//暂时没用到

    void attachView(View view);

    void attachIncomingIntent(Intent intent);//暂时没用到

}

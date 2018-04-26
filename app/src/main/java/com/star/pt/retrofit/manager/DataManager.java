package com.star.pt.retrofit.manager;

import android.content.Context;

import com.star.pt.retrofit.RetrofitHelper;
import com.star.pt.retrofit.RetrofitService;

/**
 * Created by 吴世达 on 2018/4/26.
 */

public class DataManager {
    private RetrofitService service;

    public DataManager(Context context){
        service = RetrofitHelper.getInstance(context).getRetrofitService();
    }
}

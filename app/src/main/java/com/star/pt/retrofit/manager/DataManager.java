package com.star.pt.retrofit.manager;

import android.content.Context;

import com.star.pt.retrofit.RetrofitHelper;
import com.star.pt.retrofit.RetrofitService;
import com.star.pt.retrofit.bean.Book;

import io.reactivex.Observable;


/**
 * Created by 吴世达 on 2018/4/26.
 */

public class DataManager {
    private RetrofitService service;

    public DataManager(Context context){
        service = RetrofitHelper.getInstance(context).getRetrofitService();
    }

    public Observable<Book> getSearchBooks(String name, String tag, int start, int count){
        return service.getSearchBook(name,tag,start,count);
    }
}

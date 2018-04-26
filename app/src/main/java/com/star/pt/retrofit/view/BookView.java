package com.star.pt.retrofit.view;

import com.star.pt.retrofit.bean.Book;

/**
 * Created by 吴世达 on 2018/4/26.
 */

public interface BookView extends View{
    void onSuccess(Book book);
    void onError(String result);
}

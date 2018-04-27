package com.star.pt.retrofit.presenter;

import android.content.Context;
import android.content.Intent;

import com.star.pt.retrofit.bean.Book;
import com.star.pt.retrofit.manager.DataManager;
import com.star.pt.retrofit.view.BookView;
import com.star.pt.retrofit.view.View;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 吴世达 on 2018/4/26.
 */

public class BookPresenter implements Presenter {
    private Context mContext;
    private DataManager dataManager;
    private BookView mBookView;
    private Book mBook;

    public BookPresenter(Context context){
        this.mContext = context;
    }

    @Override
    public void onCreate() {
        dataManager = new DataManager(mContext);
//        Subscription subscription =
//        ArrayCompositeSubscription mm=new ArrayCompositeSubscription();
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
        mBookView = (BookView) view;
    }

    @Override
    public void attachIncomingIntent(Intent intent) {

    }

    public void getSearchBook(String name,String tag,Integer start,Integer count){
        dataManager.getSearchBooks(name,tag,start,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Book>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Book value) {
                mBook=value;
            }

            @Override
            public void onError(Throwable e) {
                mBookView.onError(e.getMessage());
            }

            @Override
            public void onComplete() {
                if(mBook!=null){
                    mBookView.onSuccess(mBook);
                }
            }
        });
    }
}

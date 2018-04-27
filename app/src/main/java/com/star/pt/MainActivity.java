package com.star.pt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.star.pt.retrofit.bean.Book;
import com.star.pt.retrofit.presenter.BookPresenter;
import com.star.pt.retrofit.view.BookView;

public class MainActivity extends AppCompatActivity {
    private BookPresenter bookPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void init(){
        bookPresenter=new BookPresenter(this);
        bookPresenter.onCreate();
        bookPresenter.attachView(bookView);
    }

    private BookView bookView = new BookView() {
        @Override
        public void onSuccess(Book book) {
            Log.i("jj",book.toString());
        }

        @Override
        public void onError(String result) {
            Log.i("jj",result);
        }
    };

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_1:
                init();
//                Map<String, String> options = new HashMap<>();
//                options.put("q","金瓶梅");
//                options.put("start","0");
//                options.put("end","1");
                bookPresenter.getSearchBook("金瓶梅",null,0,1);
//                RetrofitHelper.exc();
                break;
        }
    }
}

package com.star.pt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.star.pt.retrofit.RetrofitExcutor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_1:
                RetrofitExcutor.exc();
                break;
        }
    }
}

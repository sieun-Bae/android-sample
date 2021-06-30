package com.example.summary6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //앱 실행되는 시점에 만들거나 오픈
        AppHelper.openDatabase(getApplicationContext(), "movie");

        //테이블 생성
        AppHelper.createTable("outline");
        //각각의 영화상세 정보를 저장할 movie table을 만들고
        //한줄평의 경우 review table을 만들면 되겠죠.

    }
}
package com.example.serenite;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class FindDate extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_date);

        // 툴바 표시
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setLogo(R.mipmap.ic_heart);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


    }
}

/*
Datepicker에서 선택 날짜 반환하기
https://parkho79.tistory.com/72
*/

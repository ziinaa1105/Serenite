package com.example.serenite;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class OneMonth_page extends AppCompatActivity {
    TextView tx1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_month_page);

        // 툴바 표시
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setLogo(R.mipmap.ic_heart);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        // OneMonth에서 선택한 년, 월 받아오기. 에러나니까 다른 방법 찾아보기
        /*
       Intent intent = getIntent();
        tx1 = (TextView)findViewById(R.id.what_month);
        int year = intent.getExtras().getInt("Year");
        int month = intent.getExtras().getInt("Month")+1;
        String date = Integer.toString(year)+"년 " + Integer.toString(month)+"월의 행복";
        tx1.setText(date);

        //날짜 색바꾸기
        TextPaint paint1 = tx1.getPaint();
        float width1 = paint1.measureText(date);
        Shader textShader1 = new LinearGradient(0, 0, width1, tx1.getTextSize(),
                new int[]{
                        Color.parseColor("#fa5050"),
                        Color.parseColor("#faa850"),
                        Color.parseColor("#66ed5f"),
                        Color.parseColor("#60b4f0"),
                        Color.parseColor("#c15df0"),
                }, null, Shader.TileMode.MIRROR);
        tx1.getPaint().setShader(textShader1);
        */

    }
}

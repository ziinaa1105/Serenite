package com.example.serenite;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class FindDate extends AppCompatActivity {
    int mYear, mMonth, mDay;
    int mYear2, mMonth2, mDay2;
    DatePicker datepicker;
    Button GetDate, GoToDaily;
    TextView goal_date;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_date);

        // 툴바 표시
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setLogo(R.mipmap.ic_heart_foreground);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        datepicker = (DatePicker)findViewById(R.id.datePicker1);
        goal_date = (TextView) findViewById(R.id.what_date);
        GetDate = (Button) findViewById(R.id.button1);
        GoToDaily = (Button) findViewById(R.id.button2);



    }
    public void monClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                mYear = datepicker.getYear();
                mMonth = datepicker.getMonth()+1;
                mDay = datepicker.getDayOfMonth();
                String goaldatetxt = mYear + "년 " + mMonth+ "월 " + mDay + "일";
                goal_date.setText(goaldatetxt);
                TextPaint paint = goal_date.getPaint();
                float width = paint.measureText(goaldatetxt);
                Shader textShader = new LinearGradient(0, 0, width, goal_date .getTextSize(),
                        new int[]{
                                Color.parseColor("#fa5050"),
                                Color.parseColor("#faa850"),
                                Color.parseColor("#66ed5f"),
                                Color.parseColor("#60b4f0"),
                                Color.parseColor("#c15df0"),
                        }, null, Shader.TileMode.CLAMP);
                goal_date .getPaint().setShader(textShader);
                break;

            case R.id.button2:
                Intent intent2 = new Intent(this,DailyDiary2.class);

                mYear2 = datepicker.getYear();
                mMonth2 = datepicker.getMonth()+1;
                mDay2 = datepicker.getDayOfMonth();
                intent2.putExtra("year", mYear2);
                intent2.putExtra("mon", mMonth2);
                intent2.putExtra("day",mDay2);
                startActivity(intent2);
                break;
        }
    }


}
      /*
        GetDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mYear = datepicker.getYear();
                mMonth = datepicker.getMonth()+1;
                mDay = datepicker.getDayOfMonth();

                String goaldatetxt = mYear + "년 " + mMonth+ "월 " + mDay + "일";
                goal_date.setText(goaldatetxt);
                TextPaint paint = goal_date.getPaint();
                float width = paint.measureText(goaldatetxt);
                Shader textShader = new LinearGradient(0, 0, width, goal_date .getTextSize(),
                        new int[]{
                                Color.parseColor("#fa5050"),
                                Color.parseColor("#faa850"),
                                Color.parseColor("#66ed5f"),
                                Color.parseColor("#60b4f0"),
                                Color.parseColor("#c15df0"),
                        }, null, Shader.TileMode.CLAMP);
                goal_date .getPaint().setShader(textShader);
            }
        });

        GoToDaily.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mYear2 = datepicker.getYear();
                mMonth2 = datepicker.getMonth()+1;
                mDay2 = datepicker.getDayOfMonth();
                String GoalDateTxt =  mYear2 + "년 " + mMonth2+ "월 " + mDay2 + "일";
                Intent find_date = new Intent(getApplicationContext(),DailyDiary2.class);

                find_date.putExtra("from_finddate",GoalDateTxt);
                startActivity(find_date);
                finish();
            }
        });
        */
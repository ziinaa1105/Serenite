package com.example.serenite;

import android.app.DatePickerDialog;
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
    DatePicker datepicker;
    Button GetDate;
    TextView goal_date;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_date);

        // 툴바 표시
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setLogo(R.mipmap.ic_heart);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        datepicker = (DatePicker)findViewById(R.id.datePicker1);
        goal_date = (TextView) findViewById(R.id.what_date);
        GetDate = (Button) findViewById(R.id.button1);

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

    }


}

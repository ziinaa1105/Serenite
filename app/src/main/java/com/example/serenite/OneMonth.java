package com.example.serenite;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class OneMonth extends Activity {
    DatePicker datepicker;
    int mYear, mMonth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_month);
        datepicker = (DatePicker)findViewById(R.id.datePicker2);

    }
    // 확인, 취소 버튼 만들기
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cancel:
                // 취소버튼 -> 메인화면
                Intent go_to_main = new Intent(OneMonth.this, MainActivity.class);
                startActivity(go_to_main);
                break;

            case R.id.btn_confirm:
                // 확인 페이지 -> 그 해당 달의 화면
                Intent go_to_month_page = new Intent(this,OneMonth_page.class);
                mYear = datepicker.getYear();
                mMonth = datepicker.getMonth()+1;
                go_to_month_page.putExtra("Year", mYear);
                go_to_month_page.putExtra("Mon", mMonth);
                startActivity(go_to_month_page);
                break;
        }
    }
}




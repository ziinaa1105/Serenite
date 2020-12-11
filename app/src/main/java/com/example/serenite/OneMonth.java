package com.example.serenite;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.NumberPicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class OneMonth extends Activity {
    private static final int MAX_YEAR = 2030;
    private static final int MIN_YEAR = 2010;

    private static final int MAX_MONTH = 12;
    private static final int MIN_MONTH = 1;



    int ye, mo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_month);

        NumberPicker monthPicker = (NumberPicker) findViewById(R.id.picker_month);
        NumberPicker yearPicker = (NumberPicker) findViewById(R.id.picker_year);

        yearPicker.setMinValue(MIN_YEAR);
        yearPicker.setMaxValue(MAX_YEAR);

        monthPicker.setMinValue(MIN_MONTH);
        monthPicker.setMaxValue(MAX_MONTH);

        ye = yearPicker.getValue();
        mo = monthPicker.getValue();

        Button btncancel = findViewById(R.id.btn_cancel);
        Button btnconfirm = findViewById(R.id.btn_confirm);

        btncancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent go_to_main = new Intent(OneMonth.this, MainActivity.class);
                startActivity(go_to_main);
            }
        });

        btnconfirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent go_to_month = new Intent(OneMonth.this, OneMonth_page.class);
                go_to_month.putExtra("ye",ye);
                go_to_month.putExtra("mo",mo);
                startActivity(go_to_month);
            }
        });




    }



}

/*

public class OneMonth extends Activity {

    private static final int MAX_YEAR = 2025;
    private static final int MIN_YEAR = 2020;

    private DatePickerDialog.OnDateSetListener listener;
    public Calendar cal = Calendar.getInstance();

    NumberPicker monthPicker = (NumberPicker) findViewById(R.id.picker_month);
    NumberPicker yearPicker = (NumberPicker) findViewById(R.id.picker_year);



    int ye, mo;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_month);
        monthPicker.setMinValue(1);
        monthPicker.setMaxValue(12);
        monthPicker.setValue(cal.get(Calendar.MONTH) + 1);

        int year = cal.get(Calendar.YEAR);
        yearPicker.setMinValue(MIN_YEAR);
        yearPicker.setMaxValue(MAX_YEAR);
        yearPicker.setValue(year);


    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_cancel:
                Intent go_to_main = new Intent(OneMonth.this, MainActivity.class);
                startActivity(go_to_main);
                break;
            case R.id.btn_confirm:




                ye = yearPicker.getValue();
                mo = monthPicker.getValue();
                Intent go_to_month = new Intent(this, OneMonth_page.class);
                go_to_month.putExtra("ye",ye);
                go_to_month.putExtra("mo",mo);
                startActivity(go_to_month);

                break;
        }
    }



}
*/


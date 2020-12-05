package com.example.serenite;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;


import java.util.Calendar;

import static java.util.Calendar.SUNDAY;
import static java.util.Calendar.getInstance;

public class MainActivity extends AppCompatActivity implements OnDateSelectedListener {

    private final Calendar calendar = Calendar.getInstance();
    MaterialCalendarView calendarView;
    // 한 달의 행복 버튼 클릭 시 페이지 이동

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 툴바 지정
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setLogo(R.mipmap.ic_heart);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("  Serenite");


        // 달력 함수
        calendarView = (MaterialCalendarView) findViewById((R.id.calendarView));
        // 날짜 한 개만 클릭 가능
        calendarView.setSelectionMode(MaterialCalendarView.SELECTION_MODE_SINGLE);
        // 날짜 클릭가능하게 세팅
        calendarView.setClickable(true);
        // 오늘 날짜 하이라이트표시
        calendarView.setSelectedDate(CalendarDay.today());
        // 날짜 클릭 시, 함수 실행
        calendarView.setOnDateChangedListener(this);

        //Calendar mon = getInstance();
        //String beforeMonth = new SimpleDateFormat("yyyy-MM-dd").format(mon.getTime());
        calendarView.state().edit()
                // 주의 시작을 일요일
                .setFirstDayOfWeek(SUNDAY)
                // 캘린더의 범위 설정
                .setMinimumDate(CalendarDay.from(2020, 01, 01))
                .setMaximumDate(CalendarDay.from(2021, 03, 01))
                //Months로 볼 건지, Weeks로 볼 건지 결정
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();


        //calendarView.setOnDateChangedListener(this);
    }
    // 설정 버튼 만들기
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return true;
    }

    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {

        // 일자 페이지로 이동
        Intent intent = new Intent(this, DailyDiary.class);
        // 날짜 넘기기
        int year = date.getYear();
        int month = date.getMonth();
        int day = date.getDay();
        intent.putExtra("Year", year);
        intent.putExtra("Month", month);
        intent.putExtra("Day", day);
        // 이동
        startActivity(intent);
    }


    // 설정 눌렀을 때 날짜 설정 페이지로 이동
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_btn1:
                Intent intent = new Intent(this, FindDate.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // 한달의 행복 페이지로 이동
    public void monClick(View v){
        Intent intent;
        switch (v.getId()){
            case R.id.one_month:
                intent = new Intent(MainActivity.this, OneMonth.class);
                startActivity(intent);
                break;
        }
    }

}

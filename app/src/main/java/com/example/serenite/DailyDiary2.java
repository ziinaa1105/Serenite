package com.example.serenite;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.InputStream;

public class DailyDiary2 extends AppCompatActivity {
    TextView tx1;

    private static final int REQUEST_CODE = 0;
    private ImageView today_pic;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daily_diary);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setLogo(R.mipmap.ic_heart_foreground);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        Intent intent1 = getIntent();
        tx1 = (TextView)findViewById(R.id.diary_date);
        int year = intent1.getExtras().getInt("Year");
        int month = intent1.getExtras().getInt("Month")+1;
        int day = intent1.getExtras().getInt("Day");
        String date = Integer.toString(year)+"년 " + Integer.toString(month)+"월 " + Integer.toString(day) + "일";



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



        today_pic = findViewById(R.id.happiest_pic);

        today_pic.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == REQUEST_CODE)
        {
            if(resultCode == RESULT_OK)
            {
                try{
                    InputStream in = getContentResolver().openInputStream(data.getData());

                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();

                    today_pic.setImageBitmap(img);
                }catch(Exception e)
                {

                }
            }
            else if(resultCode == RESULT_CANCELED)
            {
                Toast.makeText(this, "다음에 다시 선택해주세요!", Toast.LENGTH_LONG).show();
            }
        }
    }

}
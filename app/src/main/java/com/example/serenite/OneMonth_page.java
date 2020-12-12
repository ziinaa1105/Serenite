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

public class OneMonth_page extends AppCompatActivity {
    TextView tx1;
    private static final int REQUEST_CODE = 0;
    private ImageView hap_pic;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_month_page);

        // 툴바 표시
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setLogo(R.mipmap.ic_heart_foreground);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


       Intent intent = getIntent();
        tx1 = (TextView)findViewById(R.id.what_month);
        int year = intent.getExtras().getInt("ye");
        int month = intent.getExtras().getInt("mo");
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

        // 사진 입력받기
        hap_pic = findViewById(R.id.happiest_pic);

        hap_pic.setOnClickListener(new View.OnClickListener(){
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

                    hap_pic.setImageBitmap(img);
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


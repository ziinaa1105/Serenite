package com.example.serenite;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;

import android.os.Bundle;
import android.view.WindowManager;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        Handler hd = new Handler();
        // 1초 후에 hd handler 실행  3000ms = 3초
        hd.postDelayed(new splashhandler(), 3000);
    }

    private class splashhandler implements Runnable {
        public void run() {
            //로딩이 끝난 후, ChoiceFunction 이동
            startActivity(new Intent(getApplication(),MainActivity.class));
            // 로딩페이지 Activity stack에서 제거
            Splash.this.finish();
        }
    }
    @Override
    public void onBackPressed() {
        //초반 플래시 화면에서 넘어갈때 뒤로가기 버튼 누르지 못하게
    }
}
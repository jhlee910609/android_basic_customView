package com.example.junhee.customviewex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    JunHeeTextView junHeeTv;
    JunHeeEditText junHeeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        junHeeTv.setText("커스텀 텍스트뷰입니다.");


    }

    private void init() {
        junHeeTv = (JunHeeTextView) findViewById(R.id.tv_junhee);
        junHeeEditText = (JunHeeEditText) findViewById(R.id.junHeeEditText);
    }
}

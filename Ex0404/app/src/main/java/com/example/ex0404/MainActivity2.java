package com.example.ex0404;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //TextView를 참조하는 객체생성 => View 초기화(★★★★★)
        TextView tvData = findViewById(R.id.tvData);

        tvData.setText("테스트 텍스트!");

    }
}
package com.example.ex0413;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    Button btnSecond;
    TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnSecond = findViewById(R.id.btnSecond);
        tvData = findViewById(R.id.tvData);

        //Intent객체생성
        Intent intent = getIntent();

        //Intent에 저장된 데이터 접근 시 get타입명Extra(name) 호출
        //기본데이터타입의 데이터 접근 시 defaultValue를 설정해야 한다!
        tvData.setText(intent.getStringExtra("data")
                +intent.getIntExtra("num1",0));


        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this,FirstActivity.class);
                startActivity(intent);
            }
        });

    }
}
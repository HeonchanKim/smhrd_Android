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
        tvData.setText(intent.getStringExtra("data"));


        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this,FirstActivity.class);
                startActivity(intent);
            }
        });

    }
}
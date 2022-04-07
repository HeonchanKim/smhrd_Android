package com.example.ex0407;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity4 extends AppCompatActivity {

    ImageView img;
    Button btnPre,btnNext;

    //이미지 배열 생성
    int[] imgArr = {R.drawable.dog1,R.drawable.dog2,R.drawable.dog3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        img = findViewById(R.id.img);

        img.setImageResource(imgArr[2]);

    }
}
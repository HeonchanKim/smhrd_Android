package com.example.ex0406;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{

    ConstraintLayout layout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btn_red = findViewById(R.id.btn1);
        Button btn_green = findViewById(R.id.btn2);
        Button btn_blue = findViewById(R.id.btn3);
        layout2 = findViewById(R.id.layout2);

        btn_red.setOnClickListener(this);
        btn_green.setOnClickListener(this);
        btn_blue.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        int viewId = view.getId();

        if(viewId == R.id.btn1){
            layout2.setBackgroundColor(Color.parseColor("#C2130A"));
        }else if(viewId == R.id.btn2){
            layout2.setBackgroundColor(Color.parseColor("#417543"));
        }else{
            layout2.setBackgroundColor(Color.parseColor("#365BC2"));
        }


    }
}
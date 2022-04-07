package com.example.ex0407;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView num;
    int number = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = findViewById(R.id.num);
        Button btnP = findViewById(R.id.btnP);
        Button btnM = findViewById(R.id.btnM);

        btnP.setOnClickListener(this);
        btnM.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();

        //TextView 값을 연산하기 위해서 정수 변환
        String num1 = num.getText().toString();
        int n = Integer.parseInt(num1);

        if(viewId == R.id.btnP){
            //연산 후 결과값을 TextView에 설정정
           n += 1;

           //setText()에 값을 넣을 경우 반드시 문자열만 가능!
           num.setText(n+"");
        }else{
            if(n > 0) {
                n -= 1;
            }
            num.setText(String.valueOf(n));
        }

        /*if(viewId == R.id.btnP){
            num.setText(String.valueOf(++number));
        }else{
            num.setText(String.valueOf(--number));
        }*/
    }
}
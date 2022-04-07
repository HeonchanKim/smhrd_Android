package com.example.ex0407;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{

    EditText etNum1;
    EditText etNum2;
    TextView tvResult;
    Button btnPlus,btnMinus,btnMul,btnDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //View를 초기화하는 메소드
        initView();

        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);

    }

    private void initView() {
        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        btnPlus = findViewById(R.id.plus);
        btnMinus = findViewById(R.id.minus);
        btnMul = findViewById(R.id.mul);
        btnDiv = findViewById(R.id.div);
        tvResult = findViewById(R.id.tvResult);
    }

    @Override
    public void onClick(View view) {
        int getId = view.getId();
        double result = 0;
        //int Num1 = Integer.parseInt(etNum1.getText().toString());
        //int Num2 = Integer.parseInt(etNum2.getText().toString());
        String getResultText = tvResult.getText().toString().substring(0,7);

        double Num1 = Double.parseDouble(etNum1.getText().toString());
        double Num2 = Double.parseDouble(etNum2.getText().toString());

        if(getId == R.id.plus){
            result = Num1+Num2;
        }else if(getId == R.id.minus){
            result = Num1-Num2;
        }else if(getId == R.id.mul){
            result = Num1*Num2;
        }else{
            result = Double.parseDouble(String.format("%.2f",Num1/Num2));
        }

        tvResult.setText(getResultText+String.valueOf(result));

    }
}
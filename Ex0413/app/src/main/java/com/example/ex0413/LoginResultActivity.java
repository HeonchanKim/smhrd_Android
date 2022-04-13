package com.example.ex0413;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LoginResultActivity extends AppCompatActivity {

    TextView tvLoginResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_result);

        tvLoginResult = findViewById(R.id.tvLoginResult);

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        String pw = intent.getStringExtra("pw");

        if(email.equals("gjscks123@gmail.com")&&pw.equals("1234")){
            tvLoginResult.setText("로그인 성공!");
        }else{
            tvLoginResult.setText("로그인 실패..");
        }
    }
}
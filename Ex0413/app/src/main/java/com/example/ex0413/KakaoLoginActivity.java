package com.example.ex0413;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class KakaoLoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText edtEmail, edtPw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kakao_login);

        btnLogin = findViewById(R.id.btnLogin);
        edtEmail = findViewById(R.id.edtEmail);
        edtPw = findViewById(R.id.edtPw);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KakaoLoginActivity.this,LoginResultActivity.class);

                intent.putExtra("email",edtEmail.getText().toString());
                intent.putExtra("pw",edtPw.getText().toString());

                startActivity(intent);
            }
        });//end btnLoginsetOnClick

    }
}
package com.example.ex0425;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edtUserId, edtUserPw;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUserId = findViewById(R.id.edtUserId);
        edtUserPw = findViewById(R.id.edtUserPw);
        btnLogin = findViewById(R.id.btnLogin);

        //버튼 클릭 시 ChatActivity로 화면전환
        //로그인한 id를 전달하기

        String[] userIdList = {"smhrd","hc"};
        String[] userPwList = {"1234","1234"};

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id = edtUserId.getText().toString();
                String pw = edtUserPw.getText().toString();

                for(int i=0;i<userIdList.length;i++){

                    if(id.equals(userIdList[i]) && pw.equals(userPwList[i])){
                        Intent intent = new Intent(LoginActivity.this,ChatActivity.class);

                        intent.putExtra("login_id",id);

                        startActivity(intent);

                        break;
                    }

                    if(i==userIdList.length-1){
                        Toast.makeText(LoginActivity.this,
                                "다시 로그인 해주세요.",
                                Toast.LENGTH_SHORT).show();
                    }

                }//end for
            }//end onClick
        });//end SetOnClickListener


    }
}
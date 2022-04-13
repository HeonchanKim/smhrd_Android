package com.example.ex0413;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {

    Button btnFirst;
    EditText edtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        btnFirst = findViewById(R.id.btnFirst);
        edtData = findViewById(R.id.edtData);

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //사용자가 입력한 데이터를 변수에 저장
                String data = edtData.getText().toString();

                //SecondActivity로 이동 하는 기능 구현
                //Intent(현재 액티비티명.this, 화면 전환할 액티비티명.class)
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);

                //Intent객체에 전달할 데이터를 저장
                intent.putExtra("data",data);

                //Intent객체를 실행시키는 메소드
                startActivity(intent);

                //현재 액티비티를 종료하는 메소드
                finish();
            }
        });

    }
}
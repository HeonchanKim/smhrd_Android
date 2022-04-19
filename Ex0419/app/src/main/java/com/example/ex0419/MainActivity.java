package com.example.ex0419;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    Button btnRequest;
    TextView tvResult;
    EditText edtURL;

    //Volley 관련 객체
    RequestQueue queue; // String 객체를 서버로 요청보내는 역할
    StringRequest request; //요청&응답에 대한 로직을 담고있는 객체

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRequest = findViewById(R.id.btnRequest);
        tvResult = findViewById(R.id.tvResult);
        edtURL = findViewById(R.id.edtURL);

        //RequestQueue객체 초기화
        queue = Volley.newRequestQueue(MainActivity.this);

        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //edtURL 객체로부터 사용자가 입력한 URL 데이터를 받아온 후
                //request객체에 요청주소로 전달해보기
                String url = "https://"+edtURL.getText().toString();

                //StringRequest객체 생성
                //new StringRequest(데이터전송방식, 요청주소, 응답리스너, 에러리스너)
                //데이터전송방식: GET or POST
                //요청주소: 요청할 주소 ex) http:~ or https:~
                //응답리스너: 서버에서 응답이 왔을 때 실행하는 리스너
                //오류리스너: 요청 or 응답에서 오류가 발생했을 때 실행하는 리스너
                request = new StringRequest(
                        Request.Method.GET,
                        url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                tvResult.setText(response);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(MainActivity.this,
                                        error.toString(),
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                );

                //★★★
                //서버에 요청을 보내는 메소드
                queue.add(request);

            }
        });



    }
}
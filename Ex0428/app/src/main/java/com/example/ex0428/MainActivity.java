package com.example.ex0428;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvNumber,tvNumber2;
    Button btnStart,btnStart2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNumber = findViewById(R.id.tvNumber);
        btnStart = findViewById(R.id.btnStart);
        tvNumber2 = findViewById(R.id.tvNumber2);
        btnStart2 = findViewById(R.id.btnStart2);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimerThread thread = new TimerThread(tvNumber);
                thread.start();

                btnStart.setEnabled(false);
            }
        });

        btnStart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimerThread thread2 = new TimerThread(tvNumber2);
                thread2.start();

                btnStart2.setEnabled(false);
            }
        });
    }// end onCreate

    //Thread(스레드)
    // : 하나의 프로세스 내에서 작업을 처리하는 작은 단위
    // : Main Thread 이외에 작업을 별도로 처리할 때 활용

    //Main Thread의 역할
    // : UI를 업데이트하는 역할

    class TimerThread extends Thread{

        TimerHandler handler = new TimerHandler();
        TextView tv;

        public TimerThread(TextView tv){
            this.tv = tv;
        }

        @Override
        public void run() {
            //실행할 로직 정의
            for(int i = 0;i < 10;i++){
                Log.d("TimmerThread","카운트:"+(i+1));

                //tvNumber.setText(String.valueOf(i+1));

                //Handler에 값을 전달 -> Message 객체
                Message msg = new Message();
                msg.arg1 = i + 1;
                msg.obj = tv; // TextView -> Object로 업캐스팅되서 저장


                //Message객체 전송
                handler.sendMessage(msg);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }//end run()
    }//end TimerThread class

    class TimerHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            //Sub Thread에서 처리한 결과를 UI업데이트 할 때
            //handlerMessage() 안에 정의

            int count = msg.arg1;
            TextView tv = (TextView) msg.obj; //Object타입으로 저장된 TextView객체를 다운캐스팅

            //tvNumber.setText(String.valueOf(count));

            //TimerThread객체생성 시 넘겨받은 Textview객체에 내용을 업데이트
            tv.setText(String.valueOf(count)); //

        }
    }//end TimerHandler class

}
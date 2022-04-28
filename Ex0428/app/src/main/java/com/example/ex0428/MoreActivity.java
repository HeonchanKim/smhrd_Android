package com.example.ex0428;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;

public class MoreActivity extends AppCompatActivity {

    TextView tvTime, tvCount;
    ImageView[] moreArr = new ImageView[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        tvTime = findViewById(R.id.tvTime);
        tvCount = findViewById(R.id.tvCount);

        //동적으로 리소스ID접근 후 ImageView 초기화
        for(int i=0;i< moreArr.length;i++){

            //img1 ~ img9까지의 리소스ID 접근
            int resId = getResources().getIdentifier("img"+(i+1),"id",getPackageName());
            moreArr[i] = findViewById(resId);

            MoreMoveThread thread = new MoreMoveThread();
            thread.start();

        }
    }//end onCreate

    class MoreMoveThread extends Thread{

        MoreMoveHandler handler = new MoreMoveHandler();

        @Override
        public void run() {
            while(true) {
                //아래 머물러 있는 시간
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //저장해야 할 데이터: 두더지 번호, 변경할 두더지 이미지, 두더지 상태
                Message msg = new Message();
                msg.arg1 = 1;
                msg.arg2 = R.drawable.up;
                msg.obj = "up";

                handler.sendMessage(msg);

                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                msg = new Message();
                msg.arg1 = 1;
                msg.arg2 = R.drawable.down;
                msg.obj = "down";

                handler.sendMessage(msg);
            }
        }
    }//end MoreMoveThread class

    class MoreMoveHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {

            int pos = msg.arg1;
            int img = msg.arg2;
            String status = (String) msg.obj;

            moreArr[pos].setImageResource(img);

        }
    }//end MoreMoveHandler class


}
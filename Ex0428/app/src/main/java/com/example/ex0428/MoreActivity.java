package com.example.ex0428;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MoreActivity extends AppCompatActivity {

    TextView tvTime, tvCount;
    ImageView[] moreArr = new ImageView[9];
    boolean isPlaying = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        //타이머 스레드 생성
        MoreTimerThread t_thread  = new MoreTimerThread();
        t_thread.start();

        tvTime = findViewById(R.id.tvTime);
        tvCount = findViewById(R.id.tvCount);

        //동적으로 리소스ID접근 후 ImageView 초기화
        for(int i=0;i< moreArr.length;i++){
            final int pos = i;

            //img1 ~ img9까지의 리소스ID 접근
            int resId = getResources().getIdentifier("img"+(i+1),"id",getPackageName());
            moreArr[i] = findViewById(resId);

            //imageView에 tag설정
            //tag: View에 대한 상태값 저장
            moreArr[i].setTag("down");

            MoreMoveThread thread = new MoreMoveThread(i);
            thread.start();

            //두더지(ImageView)를 클릭했을 때
            moreArr[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String status = moreArr[pos].getTag().toString();

                    //두더지의 상태체크 -> 잡은개수를 업데이트(증/감)
                    //잡은개수에 대한 카운트 기능을 구현하시오.
                    int count = Integer.parseInt(tvCount.getText().toString());

                    if(status.equals("up")){
                        count += 1;
                    }else{
                        if(count > 0){
                            count -= 1;
                        }
                    }
                    tvCount.setText(String.valueOf(count));
                }
            });
        }//end for
    }//end onCreate

    class MoreMoveThread extends Thread{

        MoreMoveHandler handler = new MoreMoveHandler();

        int more_pos;

        public MoreMoveThread(int more_pos){
            this.more_pos = more_pos;
        }

        @Override
        public void run() {

            Random random = new Random();
            //두더지가 위/아래 머물러 있는 시간을 랜덤으로 생성하시오.
            while(isPlaying) {
                int downTime = random.nextInt(1500)+500;
                int upTime = random.nextInt(1500)+500;

                //아래 머물러 있는 시간
                try {
                    Thread.sleep(upTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //저장해야 할 데이터: 두더지 번호, 변경할 두더지 이미지, 두더지 상태
                Message msg = new Message();
                msg.arg1 = more_pos;
                msg.arg2 = R.drawable.up;
                msg.obj = "up";

                handler.sendMessage(msg);

                try {
                    Thread.sleep(downTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                msg = new Message();
                msg.arg1 = more_pos;
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
            moreArr[pos].setTag(status); //up down 상태값 저장

        }
    }//end MoreMoveHandler class

    class MoreTimerThread extends Thread{

        MoreTimerHandler handler = new MoreTimerHandler();

        @Override
        public void run() {

            for(int i = 30;i > -1;i--){
                Message msg = new Message();
                msg.arg1 = i;

                handler.sendMessage(msg);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }//end for
        }// end run()
    }//end MoreTimerThread class

    class MoreTimerHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            int time = msg.arg1;
            tvTime.setText(String.valueOf(time));

            //0초가 되었을 때 두더지 움직임 정지
            if(time == 0){
                isPlaying = false;
            }
        }
    }//end MoreTimerHandler class
}
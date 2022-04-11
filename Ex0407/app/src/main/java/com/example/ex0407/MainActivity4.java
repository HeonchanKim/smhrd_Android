package com.example.ex0407;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity4 extends AppCompatActivity{

    ImageView img;
    Button btnPre,btnNext;
    int cnt = 0;
    //이미지 배열 생성
    int[] imgArr = {R.drawable.dog1,R.drawable.dog2,R.drawable.dog3};
    int idx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        img = findViewById(R.id.img);
        btnPre = findViewById(R.id.btnPre);
        btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(idx == imgArr.length-1){
                    idx = 0;
                }else{
                    idx += 1;
                }
                img.setImageResource(imgArr[idx]);
            }
        }); //end btnNext

        btnPre.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(idx == 0){
                    idx = imgArr.length-1;
                }else{
                    idx -= 1;
                }
                img.setImageResource(imgArr[idx]);
            }
        });
    }//end onCreate

//    @Override
//    public void onClick(View view) {
//        int getId = view.getId();
//
//        if(getId == R.id.btnNext){
//            cnt++;
//            if(cnt > 2){
//                cnt = 0;
//            }
//            img.setImageResource(imgArr[cnt]);
//        }else{
//            cnt--;
//            if(cnt < 0){
//                cnt = 2;
//            }
//            img.setImageResource(imgArr[cnt]);
//        }
//    }
}
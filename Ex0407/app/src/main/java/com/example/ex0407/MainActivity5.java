package com.example.ex0407;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity5 extends AppCompatActivity {

    TextView tvUser1,tvUser2;
    ImageView imgDice1,imgDice2;
    Button btnShake;
    Random ran;

    //이미지 배열 생성
    int[] imgArr = {R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,
                    R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        tvUser1 = findViewById(R.id.tvUser1);
        tvUser2 = findViewById(R.id.tvUser2);
        imgDice1 = findViewById(R.id.imgDice1);
        imgDice2 = findViewById(R.id.imgDice2);
        btnShake = findViewById(R.id.btnShake);

        ran = new Random();

        btnShake.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //1. 랜덤수를 2개 생성(범위:0~5)
                //2. 랜덤수를 인덱스로 활용하여 imgArr에 접근
                //3. 접근한 이미지값을 imgDice1, imgDice2에 적용
                int idx1 = ran.nextInt(6);
                int idx2 = ran.nextInt(6);

                //이미지 변경
                imgDice1.setImageResource(imgArr[idx1]);
                imgDice2.setImageResource(imgArr[idx2]);

                //4. 2개의 TextView의 내용을 변수에 저장
                //5. 연산이 가능하도록 정수로 변환
                //6. 두 주사위눈을 비교하여 큰 쪽에 + 1 되도록 구현
                int user1 = Integer.parseInt(tvUser1.getText().toString());
                int user2 = Integer.parseInt(tvUser2.getText().toString());

                if(idx1 == idx2){
                    Toast.makeText(MainActivity5.this,
                                    "무승부!",
                                    Toast.LENGTH_SHORT).show();
                }else if(idx1 > idx2){
                    user1 += 1;
                    tvUser1.setText(String.valueOf(user1));
                }else{
                    user2 += 1;
                    tvUser2.setText(String.valueOf(user2));
                }
            }
        });//end setOnClickListener

    }
}
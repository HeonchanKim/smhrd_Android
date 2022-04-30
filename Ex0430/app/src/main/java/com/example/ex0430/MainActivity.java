package com.example.ex0430;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;
    Fragment1 frag_home;
    Fragment2 frag_time;
    Fragment3 frag_option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottmNav);

        frag_home = new Fragment1();
        frag_time = new Fragment2();
        frag_option = new Fragment3();

        //실행 시 처음에 보여줄 프래그먼트 화면 설정
        //replace(프래그먼트를 보여주는 레이아웃ID ,보여줄 프래그먼트객체)
        getSupportFragmentManager().beginTransaction().replace(R.id.container, frag_home).commit();

        //메뉴버튼 클릭 시 화면전환 기능구현
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                //선택한 메뉴버튼에 대한 리소스ID 저장
                int itemId = item.getItemId();

                if(itemId == R.id.home){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, frag_home).commit();
                }else if(itemId == R.id.time){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, frag_time).commit();
                }else{
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, frag_option).commit();
                }

                return false;
            }
        });


    }
}
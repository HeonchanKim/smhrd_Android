package com.example.ex0414;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {

    ListView lvProduct;
    ProductAdapter adapter;
    ArrayList<ProductVO> list;
    //int[] imgArr = {R.drawable.item1,R.drawable.item2,R.drawable.item3,R.drawable.item4,R.drawable.item5,R.drawable.item6,R.drawable.item7,R.drawable.item8,R.drawable.item9,R.drawable.item10,R.drawable.item11};
    //String[] pro_name = {"텀블러","슬리퍼","케이스","인형","피규어","안마봉","마우스패드","노트","필통","파우치","티셔츠"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        lvProduct = findViewById(R.id.lvProduct);
        list = new ArrayList<ProductVO>();

        //리소스ID를 동적으로 접근하는 방법
        for (int i = 0;i < 11;i++){
            //리소스객체접근.리소스ID반환메소드(리소스ID, 리소스타입, 패키지명)
            int imgId = getResources().getIdentifier("item"+(i+1),"drawable",getPackageName());
            int strId = getResources().getIdentifier("item"+(i+1),"string",getPackageName());

            list.add(new ProductVO(imgId,strId,"상품 개수 : 10"));
        }

        adapter = new ProductAdapter(
                ProductActivity.this,
                R.layout.product_item,
                list
        );

        lvProduct.setAdapter(adapter);
    }
}
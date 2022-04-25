package com.example.ex0425;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {

    ListView chatList;
    ChatAdapter adapter;
    ArrayList<ChatVO> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        chatList = findViewById(R.id.rcChatlist);
        list = new ArrayList<>();

        adapter = new ChatAdapter(ChatActivity.this,
                                    R.layout.chat_item,
                                    list);
        chatList.setAdapter(adapter);

    }
}
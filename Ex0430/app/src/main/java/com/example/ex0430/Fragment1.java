package com.example.ex0430;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Fragment1 extends Fragment {

    WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_1, container, false);

        webView = view.findViewById(R.id.webView);

        //SharedPreferences에 저장된 데이터를 접근
        String url = getActivity()
                    .getSharedPreferences("mySPF", Context.MODE_PRIVATE)
                    .getString("url","https://www.smhrd.or.kr");

        //안드로이드에 설치되어있는 기본 브라우저를 실행
        // --> WebSettings객체를 이용해서 WebView에 바로 띄워지도록 설정
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);  //자바스크립트 사용허용

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);

        return view;
    }//end onCreateView
}
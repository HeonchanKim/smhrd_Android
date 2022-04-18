package com.example.ex0414;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProViewHolder {

    private Button btnProDetail;
    private TextView tvProductName;
    private TextView tvProCount;
    private ImageView imgPro;

    public ProViewHolder(View itemView) {
        this.btnProDetail = itemView.findViewById(R.id.btnProDetail);
        this.tvProductName = itemView.findViewById(R.id.tvProName);
        this.tvProCount = itemView.findViewById(R.id.tvProCount);
        this.imgPro = itemView.findViewById(R.id.imgPro);
    }

    public Button getBtnProDetail() {
        return btnProDetail;
    }

    public TextView getTvProductName() {
        return tvProductName;
    }

    public TextView getTvProCount() {
        return tvProCount;
    }

    public ImageView getImgPro() {
        return imgPro;
    }
}

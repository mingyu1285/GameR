package com.mingyu1285.gamer;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //나한테 온 택배기사 참조하기
        Intent intent= getIntent();
        String name= intent.getStringExtra("Name");
        int imgID= intent.getIntExtra("img", R.drawable.pubg);

        iv= findViewById(R.id.iv);
        Glide.with(this).load(imgID).into(iv);


        //전환효과 반영하기
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            iv.setTransitionName("IMG");
        }


    }
}

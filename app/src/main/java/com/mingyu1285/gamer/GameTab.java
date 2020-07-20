package com.mingyu1285.gamer;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GameTab extends AppCompatActivity {

    ArrayList<GameList> gameLists = new ArrayList<>();
    MyAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

//대량의 Data를 추가


}

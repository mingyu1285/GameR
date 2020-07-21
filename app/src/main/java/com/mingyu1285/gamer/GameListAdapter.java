package com.mingyu1285.gamer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GameListAdapter extends BaseAdapter {

    ArrayList<GameList> gameLists;
    LayoutInflater inflater;

    public GameListAdapter(ArrayList<GameList> gameLists, LayoutInflater inflater) {
        this.gameLists = gameLists;
        this.inflater = inflater;
    }


    @Override
    public int getCount() {
        return gameLists.size();
    }

    @Override
    public Object getItem(int position) {
        return gameLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView = inflater.inflate(R.layout.listview_item, null);
        }

        ImageView iv = convertView.findViewById(R.id.imageView);
        TextView gameName = convertView.findViewById(R.id.gameTitle);
        TextView gameExplain = convertView.findViewById(R.id.gameExplain);

        GameList gameList = gameLists.get(position);
        gameName.setText(gameList.name);
        gameExplain.setText(gameList.explain);
        iv.setImageResource(gameList.imgId);
        return convertView;
    }
}

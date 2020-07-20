package com.mingyu1285.gamer;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class GameTabAdapter extends FragmentPagerAdapter {

    Fragment[] fragments = new Fragment[2];
    String[] tabTexts = new String[]{"FPS", "RPG", "캐주얼"};


    public GameTabAdapter(@NonNull FragmentManager fm) {
        super(fm);

    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}

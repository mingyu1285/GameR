package com.mingyu1285.gamer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class VideoTabAdapter extends FragmentPagerAdapter {

    Fragment[] fragments = new Fragment[2];
    String[] tabTexts = new String[]{"FPS영상", "RPG영상"};


    public VideoTabAdapter(@NonNull FragmentManager fm) {
        super(fm);

        fragments[0] = new GameTabViewPager1();
        fragments[1] = new GameTabViewPager2();

    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTexts[position];
    }
}

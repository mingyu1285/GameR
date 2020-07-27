package com.mingyu1285.gamer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CategoryTabAdapter extends FragmentPagerAdapter {

    Fragment[] fragments = new Fragment[2];
    String[] tabTexts = new String[]{"게임", "오프라인 구매처"};


    public CategoryTabAdapter(@NonNull FragmentManager fm) {
        super(fm);

        fragments[0] = new CategoryTabViewPager1();
        fragments[1] = new CategoryTabViewPager2();

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

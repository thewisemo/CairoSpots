package com.example.android.cairospots;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SpotFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 4;
    //    private String tabTitles[] = new String[]{"Historic", "Green", "Food", "Play"};
    private Context context;

    // The constructor
    public SpotFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MuseumsFragment();
        } else if (position == 1) {
            return new GreenFragment();
        } else if (position == 2) {
            return new FoodFragment();
        } else {
            return new PlayFragment();
        }
    }


    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getResources().getString(R.string.historic);
            case 1:
                return context.getResources().getString(R.string.green);
            case 2:
                return context.getResources().getString(R.string.food);
            case 3:
                return context.getResources().getString(R.string.play);
        }
        return super.getPageTitle(position);
    }

//    @Override
//    public CharSequence getPageTitle(int position) {
//        // Generate title based on item position
//        return tabTitles[position];
//    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}

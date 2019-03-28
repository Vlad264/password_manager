package ru.nsu.bashev.modules.example;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ExampleFragmentAdapter extends FragmentPagerAdapter {


    public ExampleFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return new ExampleFragment();
    }

    @Override
    public int getCount() {
        return 2;
    }

}

package ru.nsu.bashev.modules.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.pixelcan.inkpageindicator.InkPageIndicator;

import ru.nsu.bashev.R;

public abstract class SwapFragmentActivity extends AppCompatActivity {

    protected ViewPager viewPager;
    protected InkPageIndicator pageIndicator;
    protected FragmentPagerAdapter adapter;
    protected abstract FragmentPagerAdapter createFragmentPagerAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swap_fragment);

        viewPager = findViewById(R.id.swapViewPager);
        adapter = createFragmentPagerAdapter();
        viewPager.setAdapter(adapter);

        pageIndicator = findViewById(R.id.swapInkPagerIndicator);
        pageIndicator.setViewPager(viewPager);
    }

}

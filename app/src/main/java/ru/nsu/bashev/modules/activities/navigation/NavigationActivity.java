package ru.nsu.bashev.modules.activities.navigation;

import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;

import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.modules.base.SwapFragmentActivity;

public class NavigationActivity extends SwapFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected FragmentPagerAdapter createFragmentPagerAdapter() {
        return new NavigationFragmentAdapter(getSupportFragmentManager(), UseCaseHandler.getInstance());
    }
}

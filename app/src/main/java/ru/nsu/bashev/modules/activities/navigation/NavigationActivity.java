package ru.nsu.bashev.modules.activities.navigation;

import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;

import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.modules.base.SwapFragmentActivity;
import ru.nsu.bashev.modules.database.account.AccountDBHandler;
import ru.nsu.bashev.modules.database.account.IAccountDBHandler;

public class NavigationActivity extends SwapFragmentActivity {

    IAccountDBHandler accountDBHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        accountDBHandler = new AccountDBHandler(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected FragmentPagerAdapter createFragmentPagerAdapter() {
        return new NavigationFragmentAdapter(getSupportFragmentManager(), UseCaseHandler.getInstance(), accountDBHandler);
    }
}

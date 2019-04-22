package ru.nsu.bashev.modules.activities.navigation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.modules.activities.navigation.accountList.AccountsListFragment;
import ru.nsu.bashev.modules.activities.navigation.accountList.AccountsListPresenter;
import ru.nsu.bashev.modules.activities.navigation.accountList.IAccountsListPresenter;
import ru.nsu.bashev.modules.activities.navigation.categoriesList.CategoriesListFragment;
import ru.nsu.bashev.modules.activities.navigation.categoriesList.CategoriesListPresenter;
import ru.nsu.bashev.modules.activities.navigation.categoriesList.ICategoriesListPresenter;
import ru.nsu.bashev.modules.database.account.IAccountDBHandler;

public class NavigationFragmentAdapter extends FragmentPagerAdapter {

    private UseCaseHandler handler;
    private IAccountDBHandler accountDBHandler;

    public NavigationFragmentAdapter(FragmentManager fm, UseCaseHandler handler, IAccountDBHandler accountDBHandler) {
        super(fm);
        this.handler = handler;
        this.accountDBHandler = accountDBHandler;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i % 2) {
            case 0: {
                AccountsListFragment fragment = new AccountsListFragment();
                IAccountsListPresenter presenter = new AccountsListPresenter(fragment, handler, accountDBHandler);
                fragment.setPresenter(presenter);
                return fragment;
            }
            case 1: {
                CategoriesListFragment fragment = new CategoriesListFragment();
                ICategoriesListPresenter presenter = new CategoriesListPresenter(fragment, handler);
                fragment.setPresenter(presenter);
                return fragment;
            }
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}

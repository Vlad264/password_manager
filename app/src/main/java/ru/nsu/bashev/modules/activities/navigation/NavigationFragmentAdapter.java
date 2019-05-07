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
import ru.nsu.bashev.modules.database.categories.ICategoriesDBHandler;

public class NavigationFragmentAdapter extends FragmentPagerAdapter {

    private UseCaseHandler handler;
    private IAccountDBHandler accountDBHandler;
    private ICategoriesDBHandler categoriesDBHandler;

    public NavigationFragmentAdapter(FragmentManager fm, UseCaseHandler handler, IAccountDBHandler accountDBHandler, ICategoriesDBHandler categoriesDBHandler) {
        super(fm);
        this.handler = handler;
        this.accountDBHandler = accountDBHandler;
        this.categoriesDBHandler = categoriesDBHandler;
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
                ICategoriesListPresenter presenter = new CategoriesListPresenter(fragment, handler, categoriesDBHandler);
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

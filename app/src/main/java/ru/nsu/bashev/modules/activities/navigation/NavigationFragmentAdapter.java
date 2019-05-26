package ru.nsu.bashev.modules.activities.navigation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

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

    private AccountsListFragment accountsListFragment;
    private CategoriesListFragment categoriesListFragment;

    public NavigationFragmentAdapter(FragmentManager fm, ViewPager viewPager, UseCaseHandler handler, IAccountDBHandler accountDBHandler) {
        super(fm);

        accountsListFragment = new AccountsListFragment();
        IAccountsListPresenter accountsListPresenter = new AccountsListPresenter(accountsListFragment, handler, accountDBHandler);
        accountsListFragment.setPresenter(accountsListPresenter);

        categoriesListFragment = new CategoriesListFragment();
        ICategoriesListPresenter categoriesListPresenter = new CategoriesListPresenter(categoriesListFragment, handler, accountDBHandler);
        categoriesListPresenter.setAccountsListView(accountsListFragment);
        categoriesListPresenter.setViewPager(viewPager);
        categoriesListFragment.setPresenter(categoriesListPresenter);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i % 2) {
            case 0: {
                return accountsListFragment;
            }
            case 1: {
                return categoriesListFragment;
            }
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}

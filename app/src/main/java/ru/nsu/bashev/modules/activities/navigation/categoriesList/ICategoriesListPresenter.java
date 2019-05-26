package ru.nsu.bashev.modules.activities.navigation.categoriesList;

import android.support.v4.view.ViewPager;

import java.util.List;

import ru.nsu.bashev.model.Category;
import ru.nsu.bashev.modules.activities.navigation.accountList.IAccountsListView;
import ru.nsu.bashev.modules.base.IBasePresenter;

public interface ICategoriesListPresenter extends IBasePresenter {
    void removeCategory(long id);
    void setAccountsListView(IAccountsListView view);
    void setViewPager(ViewPager viewPager);
    void searchByCategories(List<Category> categories);
}

package ru.nsu.bashev.modules.activities.navigation.categoriesList;

import android.support.v4.view.ViewPager;

import java.util.List;

import ru.nsu.bashev.common.useCaseEngine.IUseCaseCallback;
import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.model.Category;
import ru.nsu.bashev.modules.activities.navigation.accountList.IAccountsListView;
import ru.nsu.bashev.modules.database.account.IAccountDBHandler;
import ru.nsu.bashev.modules.database.categories.ICategoriesDBHandler;
import ru.nsu.bashev.modules.useCases.DeleteCategory;
import ru.nsu.bashev.modules.useCases.LoadAccountsByCategories;
import ru.nsu.bashev.modules.useCases.LoadAccountsByLogin;
import ru.nsu.bashev.modules.useCases.LoadCategories;

public class CategoriesListPresenter implements ICategoriesListPresenter {

    private ICategoriesListView view;
    private IAccountsListView accountsListView;
    private ViewPager viewPager;
    private UseCaseHandler handler;
    private IAccountDBHandler accountDBHandler;
    private ICategoriesDBHandler categoriesDBHandler;

    public CategoriesListPresenter(ICategoriesListView view, UseCaseHandler handler, IAccountDBHandler accountDBHandler) {
        this.view = view;
        this.handler = handler;
        this.accountDBHandler = accountDBHandler;
        this.categoriesDBHandler = accountDBHandler.getCategoriesDBHandler();
    }

    @Override
    public void start() {
        LoadCategories loadCategories = new LoadCategories(categoriesDBHandler);
        LoadCategories.RequestValues request = new LoadCategories.RequestValues();
        handler.execute(loadCategories, request, new IUseCaseCallback<LoadCategories.ResponseValues>() {
            @Override
            public void onSuccess(LoadCategories.ResponseValues response) {
                view.showCategories(response.getCategories());
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public void removeCategory(long id) {
        DeleteCategory deleteCategory = new DeleteCategory(categoriesDBHandler);
        DeleteCategory.RequestValues request = new DeleteCategory.RequestValues(id);
        handler.execute(deleteCategory, request, new IUseCaseCallback<DeleteCategory.ResponseValues>() {
            @Override
            public void onSuccess(DeleteCategory.ResponseValues response) {
                start();
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public void setAccountsListView(IAccountsListView view) {
        accountsListView = view;
    }

    @Override
    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
    }

    @Override
    public void searchByCategories(List<Category> categories) {
        LoadAccountsByCategories loadAccounts = new LoadAccountsByCategories(accountDBHandler);
        LoadAccountsByCategories.RequestValues request = new LoadAccountsByCategories.RequestValues(categories);
        handler.execute(loadAccounts, request, new IUseCaseCallback<LoadAccountsByCategories.ResponseValues>() {
            @Override
            public void onSuccess(LoadAccountsByCategories.ResponseValues response) {
                viewPager.setCurrentItem(0);
                accountsListView.showAccounts(response.getAccounts());
            }

            @Override
            public void onError() {
                view.showNothing();
            }
        });
    }
}

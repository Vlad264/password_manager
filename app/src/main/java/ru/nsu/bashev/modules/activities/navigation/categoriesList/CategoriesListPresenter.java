package ru.nsu.bashev.modules.activities.navigation.categoriesList;

import ru.nsu.bashev.common.useCaseEngine.IUseCaseCallback;
import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.modules.database.categories.ICategoriesDBHandler;
import ru.nsu.bashev.modules.useCases.DeleteCategory;
import ru.nsu.bashev.modules.useCases.LoadCategories;

public class CategoriesListPresenter implements ICategoriesListPresenter {

    private ICategoriesListView view;
    private UseCaseHandler handler;
    private ICategoriesDBHandler categoriesDBHandler;

    public CategoriesListPresenter(ICategoriesListView view, UseCaseHandler handler, ICategoriesDBHandler categoriesDBHandler) {
        this.view = view;
        this.handler = handler;
        this.categoriesDBHandler = categoriesDBHandler;
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
}

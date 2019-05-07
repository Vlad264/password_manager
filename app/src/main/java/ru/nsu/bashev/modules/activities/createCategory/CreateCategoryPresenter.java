package ru.nsu.bashev.modules.activities.createCategory;

import ru.nsu.bashev.common.useCaseEngine.IUseCaseCallback;
import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.model.Category;
import ru.nsu.bashev.modules.database.categories.ICategoriesDBHandler;
import ru.nsu.bashev.modules.useCases.SaveCategory;

public class CreateCategoryPresenter implements ICreateCategoryPresenter {

    private ICreateCategoryView view;
    private UseCaseHandler handler;
    private ICategoriesDBHandler categoriesDBHandler;

    public CreateCategoryPresenter(ICreateCategoryView view, UseCaseHandler handler, ICategoriesDBHandler categoriesDBHandler) {
        this.view = view;
        this.handler = handler;
        this.categoriesDBHandler = categoriesDBHandler;
    }

    @Override
    public void start() {
        //Nothing on start
    }

    @Override
    public void saveCategory(Category category) {
        SaveCategory saveCategory = new SaveCategory(categoriesDBHandler);
        SaveCategory.RequestValues request = new SaveCategory.RequestValues(category);
        handler.execute(saveCategory, request, new IUseCaseCallback<SaveCategory.ResponseValues>() {
            @Override
            public void onSuccess(SaveCategory.ResponseValues response) {
                view.close();
            }

            @Override
            public void onError() {

            }
        });
    }
}

package ru.nsu.bashev.modules.activities.editCategory;

import ru.nsu.bashev.common.useCaseEngine.IUseCaseCallback;
import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.model.Category;
import ru.nsu.bashev.modules.database.categories.ICategoriesDBHandler;
import ru.nsu.bashev.modules.useCases.LoadCategory;
import ru.nsu.bashev.modules.useCases.SaveCategory;
import ru.nsu.bashev.modules.useCases.UpdateCategory;

public class EditCategoryPresenter implements IEditCategoryPresenter {

    private IEditCategoryView view;
    private UseCaseHandler handler;
    private ICategoriesDBHandler categoriesDBHandler;
    private long id;

    public EditCategoryPresenter(IEditCategoryView view, UseCaseHandler handler, ICategoriesDBHandler categoriesDBHandler, long id) {
        this.view = view;
        this.handler = handler;
        this.categoriesDBHandler = categoriesDBHandler;
        this.id = id;
    }

    @Override
    public void start() {
        LoadCategory loadCategory = new LoadCategory(categoriesDBHandler);
        LoadCategory.RequestValues request = new LoadCategory.RequestValues(id);
        handler.execute(loadCategory, request, new IUseCaseCallback<LoadCategory.ResponseValues>() {
            @Override
            public void onSuccess(LoadCategory.ResponseValues response) {
                view.showInfo(response.getCategory());
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public void saveCategory(Category category) {
        UpdateCategory updateCategory = new UpdateCategory(categoriesDBHandler);
        UpdateCategory.RequestValues request = new UpdateCategory.RequestValues(id, category);
        handler.execute(updateCategory, request, new IUseCaseCallback<UpdateCategory.ResponseValues>() {
            @Override
            public void onSuccess(UpdateCategory.ResponseValues response) {
                view.close();
            }

            @Override
            public void onError() {

            }
        });
    }
}

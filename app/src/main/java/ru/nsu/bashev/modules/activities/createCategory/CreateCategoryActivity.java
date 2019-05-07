package ru.nsu.bashev.modules.activities.createCategory;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.modules.base.SingleFragmentActivity;
import ru.nsu.bashev.modules.database.categories.CategoriesDBHandler;
import ru.nsu.bashev.modules.database.categories.ICategoriesDBHandler;

public class CreateCategoryActivity extends SingleFragmentActivity {

    private ICreateCategoryPresenter presenter;
    private ICategoriesDBHandler categoriesDBHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UseCaseHandler handler = UseCaseHandler.getInstance();
        categoriesDBHandler = new CategoriesDBHandler(this);

        ICreateCategoryView view = (ICreateCategoryView) fragment;
        presenter = new CreateCategoryPresenter(view, handler, categoriesDBHandler);
        view.setPresenter(presenter);
    }

    @Override
    protected Fragment createFragment() {
        return new CreateCategoryFragment();
    }
}

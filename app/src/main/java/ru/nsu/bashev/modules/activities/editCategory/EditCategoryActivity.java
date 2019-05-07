package ru.nsu.bashev.modules.activities.editCategory;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.modules.base.SingleFragmentActivity;
import ru.nsu.bashev.modules.database.categories.CategoriesDBHandler;
import ru.nsu.bashev.modules.database.categories.ICategoriesDBHandler;

public class EditCategoryActivity extends SingleFragmentActivity {

    private IEditCategoryPresenter presenter;
    private ICategoriesDBHandler categoriesDBHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        long id = getIntent().getLongExtra("ID", 0);
        UseCaseHandler handler = UseCaseHandler.getInstance();
        categoriesDBHandler = new CategoriesDBHandler(this);

        IEditCategoryView view = (IEditCategoryView) fragment;
        presenter = new EditCategoryPresenter(view, handler, categoriesDBHandler, id);
        view.setPresenter(presenter);
    }

    @Override
    protected Fragment createFragment() {
        return new EditCategoryFragment();
    }
}

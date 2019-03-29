package ru.nsu.bashev.modules.activities.editCategory;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.modules.base.SingleFragmentActivity;

public class EditCategoryActivity extends SingleFragmentActivity {

    private IEditCategoryPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UseCaseHandler handler = UseCaseHandler.getInstance();

        IEditCategoryView view = (IEditCategoryView) fragment;
        presenter = new EditCategoryPresenter(view, handler);
        view.setPresenter(presenter);
    }

    @Override
    protected Fragment createFragment() {
        return new EditCategoryFragment();
    }
}

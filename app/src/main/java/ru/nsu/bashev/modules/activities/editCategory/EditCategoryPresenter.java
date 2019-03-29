package ru.nsu.bashev.modules.activities.editCategory;

import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;

public class EditCategoryPresenter implements IEditCategoryPresenter {

    private IEditCategoryView view;
    private UseCaseHandler handler;

    public EditCategoryPresenter(IEditCategoryView view, UseCaseHandler handler) {
        this.view = view;
        this.handler = handler;
    }

    @Override
    public void start() {
        //Nothing on start
    }
}

package ru.nsu.bashev.modules.activities.editCategory;

import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.modules.useCases.HandlePush;

public class EditCategoryPresenter implements IEditCategoryPresenter {

    private IEditCategoryView view;
    private UseCaseHandler handler;
    private HandlePush handlePush;

    public EditCategoryPresenter(IEditCategoryView view, UseCaseHandler handler, HandlePush handlePush) {
        this.view = view;
        this.handler = handler;
        this.handlePush = handlePush;
    }

    @Override
    public void start() {
        //Nothing on start
    }
}

package ru.nsu.bashev.modules.activities.createCategory;

import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.modules.useCases.HandlePush;

public class CreateCategoryPresenter implements ICreateCategoryPresenter {

    private ICreateCategoryView view;
    private UseCaseHandler handler;
    private HandlePush handlePush;

    public CreateCategoryPresenter(ICreateCategoryView view, UseCaseHandler handler, HandlePush handlePush) {
        this.view = view;
        this.handler = handler;
        this.handlePush = handlePush;
    }

    @Override
    public void start() {
        //Nothing on start
    }
}

package ru.nsu.bashev.modules.activities.createCategory;

import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;

public class CreateCategoryPresenter implements ICreateCategoryPresenter {

    private ICreateCategoryView view;
    private UseCaseHandler handler;

    public CreateCategoryPresenter(ICreateCategoryView view, UseCaseHandler handler) {
        this.view = view;
        this.handler = handler;
    }

    @Override
    public void start() {
        //Nothing on start
    }
}

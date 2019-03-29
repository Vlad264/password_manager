package ru.nsu.bashev.modules.activities.navigation.categoriesList;

import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;

public class CategoriesListPresenter implements ICategoriesListPresenter {

    private ICategoriesListView view;
    private UseCaseHandler handler;

    public CategoriesListPresenter(ICategoriesListView view, UseCaseHandler handler) {
        this.view = view;
        this.handler = handler;
    }

    @Override
    public void start() {
        //Nothing on start
    }
}

package ru.nsu.bashev.modules.activities.navigation.categoriesList;

import ru.nsu.bashev.modules.base.IBasePresenter;

public interface ICategoriesListPresenter extends IBasePresenter {
    void removeCategory(long id);
}

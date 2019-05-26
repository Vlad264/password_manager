package ru.nsu.bashev.modules.activities.navigation.categoriesList;

import java.util.List;

import ru.nsu.bashev.model.Category;
import ru.nsu.bashev.modules.base.IBaseView;

public interface ICategoriesListView extends IBaseView<ICategoriesListPresenter> {
    void showCategories(List<Category> categories);
    void showNothing();
}

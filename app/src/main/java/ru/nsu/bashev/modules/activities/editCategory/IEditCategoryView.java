package ru.nsu.bashev.modules.activities.editCategory;

import ru.nsu.bashev.model.Category;
import ru.nsu.bashev.modules.base.IBaseView;

public interface IEditCategoryView extends IBaseView<IEditCategoryPresenter> {
    void close();
    void error();
    void showInfo(Category category);
}

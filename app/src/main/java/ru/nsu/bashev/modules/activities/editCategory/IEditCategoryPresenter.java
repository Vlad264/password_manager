package ru.nsu.bashev.modules.activities.editCategory;

import ru.nsu.bashev.model.Category;
import ru.nsu.bashev.modules.base.IBasePresenter;

public interface IEditCategoryPresenter extends IBasePresenter {
    void saveCategory(Category category);
}

package ru.nsu.bashev.modules.activities.createCategory;

import ru.nsu.bashev.model.Category;
import ru.nsu.bashev.modules.base.IBasePresenter;

public interface ICreateCategoryPresenter extends IBasePresenter {
    void saveCategory(Category category);
}

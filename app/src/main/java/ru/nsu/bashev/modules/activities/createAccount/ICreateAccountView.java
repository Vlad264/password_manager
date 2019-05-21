package ru.nsu.bashev.modules.activities.createAccount;

import java.util.List;

import ru.nsu.bashev.model.Category;
import ru.nsu.bashev.modules.base.IBaseView;

public interface ICreateAccountView extends IBaseView<ICreateAccountPresenter> {
    void showCategories(List<Category> categories);
    void close();
}

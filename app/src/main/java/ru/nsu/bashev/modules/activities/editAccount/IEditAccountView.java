package ru.nsu.bashev.modules.activities.editAccount;

import java.util.List;

import ru.nsu.bashev.model.Account;
import ru.nsu.bashev.model.Category;
import ru.nsu.bashev.modules.base.IBaseView;

public interface IEditAccountView extends IBaseView<IEditAccountPresenter> {
    void success();
    void error();
    void showInfo(Account account);
    void showCategories(List<Category> categories);
}

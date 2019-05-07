package ru.nsu.bashev.modules.activities.viewAccount;

import ru.nsu.bashev.model.Account;
import ru.nsu.bashev.modules.base.IBaseView;

public interface IViewAccountView extends IBaseView<IViewAccountPresenter> {
    void showInfo(Account account);
    void close();
    void error();
}

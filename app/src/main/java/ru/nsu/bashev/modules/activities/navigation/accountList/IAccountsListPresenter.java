package ru.nsu.bashev.modules.activities.navigation.accountList;

import ru.nsu.bashev.modules.base.IBasePresenter;

public interface IAccountsListPresenter extends IBasePresenter {
    void removeAccount(long id);
    void searchByTitle(String value);
    void searchByEmail(String value);
    void searchByLogin(String value);
}

package ru.nsu.bashev.modules.activities.navigation.accountList;

import java.util.List;

import ru.nsu.bashev.model.Account;
import ru.nsu.bashev.modules.base.IBaseView;

public interface IAccountsListView extends IBaseView<IAccountsListPresenter> {
    void showAccounts(List<Account> accounts);
}

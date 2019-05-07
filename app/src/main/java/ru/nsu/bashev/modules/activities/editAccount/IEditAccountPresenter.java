package ru.nsu.bashev.modules.activities.editAccount;

import ru.nsu.bashev.model.Account;
import ru.nsu.bashev.modules.base.IBasePresenter;

public interface IEditAccountPresenter extends IBasePresenter {
    void  saveAccount(Account account);
}

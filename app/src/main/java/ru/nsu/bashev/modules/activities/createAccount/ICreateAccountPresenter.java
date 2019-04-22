package ru.nsu.bashev.modules.activities.createAccount;

import ru.nsu.bashev.model.Account;
import ru.nsu.bashev.modules.base.IBasePresenter;

public interface ICreateAccountPresenter extends IBasePresenter {
    void saveAccount(Account account);
}

package ru.nsu.bashev.modules.activities.navigation.accountList;

import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;

public class AccountsListPresenter implements IAccountsListPresenter {

    private IAccountsListView view;
    private UseCaseHandler handler;

    public AccountsListPresenter(IAccountsListView view, UseCaseHandler handler) {
        this.view = view;
        this.handler = handler;
    }

    @Override
    public void start() {
        //Nothing on start
    }
}

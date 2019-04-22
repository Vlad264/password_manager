package ru.nsu.bashev.modules.activities.navigation.accountList;

import ru.nsu.bashev.common.useCaseEngine.IUseCaseCallback;
import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.modules.database.account.IAccountDBHandler;
import ru.nsu.bashev.modules.useCases.LoadAccounts;

public class AccountsListPresenter implements IAccountsListPresenter {

    private IAccountsListView view;
    private UseCaseHandler handler;
    private IAccountDBHandler accountDBHandler;

    public AccountsListPresenter(IAccountsListView view, UseCaseHandler handler, IAccountDBHandler accountDBHandler) {
        this.view = view;
        this.handler = handler;
        this.accountDBHandler = accountDBHandler;
    }

    @Override
    public void start() {
        LoadAccounts loadAccounts = new LoadAccounts(accountDBHandler);
        final LoadAccounts.RequestValues request = new LoadAccounts.RequestValues();
        handler.execute(loadAccounts, request, new IUseCaseCallback<LoadAccounts.ResponseValues>() {
            @Override
            public void onSuccess(LoadAccounts.ResponseValues response) {
                view.showAccounts(response.getAccounts());
            }

            @Override
            public void onError() {

            }
        });
    }
}

package ru.nsu.bashev.modules.activities.navigation.accountList;

import ru.nsu.bashev.common.useCaseEngine.IUseCaseCallback;
import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.modules.database.account.IAccountDBHandler;
import ru.nsu.bashev.modules.useCases.DeleteAccount;
import ru.nsu.bashev.modules.useCases.LoadAccounts;
import ru.nsu.bashev.modules.useCases.LoadAccountsByEmail;
import ru.nsu.bashev.modules.useCases.LoadAccountsByLogin;
import ru.nsu.bashev.modules.useCases.LoadAccountsByTitle;

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
        LoadAccounts.RequestValues request = new LoadAccounts.RequestValues();
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

    @Override
    public void removeAccount(long id) {
        DeleteAccount deleteAccount = new DeleteAccount(accountDBHandler);
        DeleteAccount.RequestValues request = new DeleteAccount.RequestValues(id);
        handler.execute(deleteAccount, request, new IUseCaseCallback<DeleteAccount.ResponseValues>() {
            @Override
            public void onSuccess(DeleteAccount.ResponseValues response) {
                start();
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public void searchByTitle(String value) {
        LoadAccountsByTitle loadAccounts = new LoadAccountsByTitle(accountDBHandler);
        LoadAccountsByTitle.RequestValues request = new LoadAccountsByTitle.RequestValues(value);
        handler.execute(loadAccounts, request, new IUseCaseCallback<LoadAccountsByTitle.ResponseValues>() {
            @Override
            public void onSuccess(LoadAccountsByTitle.ResponseValues response) {
                view.showAccounts(response.getAccounts());
            }

            @Override
            public void onError() {
                view.showNothing();
            }
        });
    }

    @Override
    public void searchByEmail(String value) {
        LoadAccountsByEmail loadAccounts = new LoadAccountsByEmail(accountDBHandler);
        LoadAccountsByEmail.RequestValues request = new LoadAccountsByEmail.RequestValues(value);
        handler.execute(loadAccounts, request, new IUseCaseCallback<LoadAccountsByEmail.ResponseValues>() {
            @Override
            public void onSuccess(LoadAccountsByEmail.ResponseValues response) {
                view.showAccounts(response.getAccounts());
            }

            @Override
            public void onError() {
                view.showNothing();
            }
        });
    }

    @Override
    public void searchByLogin(String value) {
        LoadAccountsByLogin loadAccounts = new LoadAccountsByLogin(accountDBHandler);
        LoadAccountsByLogin.RequestValues request = new LoadAccountsByLogin.RequestValues(value);
        handler.execute(loadAccounts, request, new IUseCaseCallback<LoadAccountsByLogin.ResponseValues>() {
            @Override
            public void onSuccess(LoadAccountsByLogin.ResponseValues response) {
                view.showAccounts(response.getAccounts());
            }

            @Override
            public void onError() {
                view.showNothing();
            }
        });
    }
}

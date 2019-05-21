package ru.nsu.bashev.modules.activities.createAccount;

import ru.nsu.bashev.common.useCaseEngine.IUseCaseCallback;
import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.model.Account;
import ru.nsu.bashev.modules.database.account.IAccountDBHandler;
import ru.nsu.bashev.modules.useCases.LoadCategories;
import ru.nsu.bashev.modules.useCases.SaveAccount;

public class CreateAccountPresenter implements ICreateAccountPresenter {

    private ICreateAccountView view;
    private UseCaseHandler handler;
    private IAccountDBHandler accountDBHandler;

    public CreateAccountPresenter(ICreateAccountView view, UseCaseHandler handler, IAccountDBHandler accountDBHandler) {
        this.view = view;
        this.handler = handler;
        this.accountDBHandler = accountDBHandler;
    }

    @Override
    public void start() {
        LoadCategories loadCategories = new LoadCategories(accountDBHandler.getCategoriesDBHandler());
        LoadCategories.RequestValues request = new LoadCategories.RequestValues();
        handler.execute(loadCategories, request, new IUseCaseCallback<LoadCategories.ResponseValues>() {
            @Override
            public void onSuccess(LoadCategories.ResponseValues response) {
                view.showCategories(response.getCategories());
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public void saveAccount(Account account) {
        SaveAccount saveAccount = new SaveAccount(accountDBHandler);
        SaveAccount.RequestValues request = new SaveAccount.RequestValues(account);
        handler.execute(saveAccount, request, new IUseCaseCallback<SaveAccount.ResponseValues>() {
            @Override
            public void onSuccess(SaveAccount.ResponseValues response) {
                view.close();
            }

            @Override
            public void onError() {

            }
        });
    }
}

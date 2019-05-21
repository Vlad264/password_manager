package ru.nsu.bashev.modules.activities.editAccount;

import ru.nsu.bashev.common.useCaseEngine.IUseCaseCallback;
import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.model.Account;
import ru.nsu.bashev.modules.database.account.IAccountDBHandler;
import ru.nsu.bashev.modules.useCases.LoadAccount;
import ru.nsu.bashev.modules.useCases.LoadCategoriesWithSelect;
import ru.nsu.bashev.modules.useCases.UpdateAccount;

public class EditAccountPresenter implements IEditAccountPresenter {

    private IEditAccountView view;
    private UseCaseHandler handler;
    private IAccountDBHandler accountDBHandler;
    private long id;

    public EditAccountPresenter(IEditAccountView view, UseCaseHandler handler, IAccountDBHandler accountDBHandler, long id) {
        this.view = view;
        this.handler = handler;
        this.accountDBHandler = accountDBHandler;
        this.id = id;
    }

    @Override
    public void start() {
        LoadAccount loadAccount = new LoadAccount(accountDBHandler);
        LoadAccount.RequestValues requestAccount = new LoadAccount.RequestValues(id);
        handler.execute(loadAccount, requestAccount, new IUseCaseCallback<LoadAccount.ResponseValues>() {
            @Override
            public void onSuccess(LoadAccount.ResponseValues response) {
                view.showInfo(response.getAccounts());
                LoadCategoriesWithSelect loadCategoriesWithSelect = new LoadCategoriesWithSelect(accountDBHandler);
                LoadCategoriesWithSelect.RequestValues requestCategories = new LoadCategoriesWithSelect.RequestValues(id);
                handler.execute(loadCategoriesWithSelect, requestCategories, new IUseCaseCallback<LoadCategoriesWithSelect.ResponseValues>() {
                    @Override
                    public void onSuccess(LoadCategoriesWithSelect.ResponseValues response) {
                        view.showCategories(response.getCategories());
                    }

                    @Override
                    public void onError() {

                    }
                });
            }

            @Override
            public void onError() {
                view.error();
            }
        });
    }

    @Override
    public void saveAccount(Account account) {
        UpdateAccount updateAccount = new UpdateAccount(accountDBHandler);
        UpdateAccount.RequestValues request = new UpdateAccount.RequestValues(id, account);
        handler.execute(updateAccount, request, new IUseCaseCallback<UpdateAccount.ResponseValues>() {
            @Override
            public void onSuccess(UpdateAccount.ResponseValues response) {
                view.success();
            }

            @Override
            public void onError() {

            }
        });
    }
}

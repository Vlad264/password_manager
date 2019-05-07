package ru.nsu.bashev.modules.activities.viewAccount;

import ru.nsu.bashev.common.useCaseEngine.IUseCaseCallback;
import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.modules.database.account.IAccountDBHandler;
import ru.nsu.bashev.modules.useCases.LoadAccount;

public class ViewAccountPresenter implements IViewAccountPresenter {

    private IViewAccountView view;
    private UseCaseHandler handler;
    private IAccountDBHandler accountDBHandler;
    private long id;

    public ViewAccountPresenter(IViewAccountView view, UseCaseHandler handler, IAccountDBHandler accountDBHandler, long id) {
        this.view = view;
        this.handler = handler;
        this.accountDBHandler = accountDBHandler;
        this.id = id;
    }

    @Override
    public void start() {
        LoadAccount loadAccount = new LoadAccount(accountDBHandler);
        LoadAccount.RequestValues request = new LoadAccount.RequestValues(id);
        handler.execute(loadAccount, request, new IUseCaseCallback<LoadAccount.ResponseValues>() {
            @Override
            public void onSuccess(LoadAccount.ResponseValues response) {
                view.showInfo(response.getAccounts());
            }

            @Override
            public void onError() {
                view.error();
            }
        });
    }

    @Override
    public long getId() {
        return id;
    }
}

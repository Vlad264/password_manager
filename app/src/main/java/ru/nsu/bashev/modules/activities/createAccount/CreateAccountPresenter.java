package ru.nsu.bashev.modules.activities.createAccount;

import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;

public class CreateAccountPresenter implements ICreateAccountPresenter {

    private ICreateAccountView view;
    private UseCaseHandler handler;

    public CreateAccountPresenter(ICreateAccountView view, UseCaseHandler handler) {
        this.view = view;
        this.handler = handler;
    }

    @Override
    public void start() {
        //Nothing on start
    }
}

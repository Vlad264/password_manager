package ru.nsu.bashev.modules.activities.createAccount;

import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.modules.useCases.HandlePush;

public class CreateAccountPresenter implements ICreateAccountPresenter {

    private ICreateAccountView view;
    private UseCaseHandler handler;
    private HandlePush handlePush;

    public CreateAccountPresenter(ICreateAccountView view, UseCaseHandler handler, HandlePush handlePush) {
        this.view = view;
        this.handler = handler;
        this.handlePush = handlePush;
    }

    @Override
    public void start() {
        //Nothing on start
    }
}

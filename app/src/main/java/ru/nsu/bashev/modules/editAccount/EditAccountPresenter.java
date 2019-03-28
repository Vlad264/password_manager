package ru.nsu.bashev.modules.editAccount;

import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.modules.useCases.HandlePush;

public class EditAccountPresenter implements IEditAccountPresenter {

    private IEditAccountView view;
    private UseCaseHandler handler;
    private HandlePush handlePush;

    public EditAccountPresenter(IEditAccountView view, UseCaseHandler handler, HandlePush handlePush) {
        this.view = view;
        this.handler = handler;
        this.handlePush = handlePush;
    }

    @Override
    public void start() {
        //Nothing on start
    }
}

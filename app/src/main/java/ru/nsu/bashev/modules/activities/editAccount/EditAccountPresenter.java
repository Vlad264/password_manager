package ru.nsu.bashev.modules.activities.editAccount;

import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;

public class EditAccountPresenter implements IEditAccountPresenter {

    private IEditAccountView view;
    private UseCaseHandler handler;

    public EditAccountPresenter(IEditAccountView view, UseCaseHandler handler) {
        this.view = view;
        this.handler = handler;
    }

    @Override
    public void start() {
        //Nothing on start
    }
}

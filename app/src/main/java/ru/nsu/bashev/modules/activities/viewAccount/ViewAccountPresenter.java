package ru.nsu.bashev.modules.activities.viewAccount;

import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;

public class ViewAccountPresenter implements IViewAccountPresenter {

    private IViewAccountView view;
    private UseCaseHandler handler;

    public ViewAccountPresenter(IViewAccountView view, UseCaseHandler handler) {
        this.view = view;
        this.handler = handler;
    }

    @Override
    public void start() {
        //Nothing on start
    }
}

package ru.nsu.bashev.modules.activities.enter;

import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;

public class EnterPresenter implements IEnterPresenter {

    private IEnterView view;
    private UseCaseHandler handler;

    public EnterPresenter(IEnterView view, UseCaseHandler handler) {
        this.view = view;
        this.handler = handler;
    }

    @Override
    public void start() {
        //Nothing on start
    }
}

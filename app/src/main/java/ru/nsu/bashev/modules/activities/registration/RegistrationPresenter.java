package ru.nsu.bashev.modules.activities.registration;

import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.modules.useCases.HandlePush;

public class RegistrationPresenter implements IRegistrationPresenter {

    private IRegistrationView view;
    private UseCaseHandler handler;
    private HandlePush handlePush;

    public RegistrationPresenter(IRegistrationView view, UseCaseHandler handler, HandlePush handlePush) {
        this.view = view;
        this.handler = handler;
        this.handlePush = handlePush;
    }

    @Override
    public void start() {
        //Nothing on start
    }
}

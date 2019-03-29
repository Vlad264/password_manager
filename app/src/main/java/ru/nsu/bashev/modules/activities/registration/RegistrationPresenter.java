package ru.nsu.bashev.modules.activities.registration;

import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;

public class RegistrationPresenter implements IRegistrationPresenter {

    private IRegistrationView view;
    private UseCaseHandler handler;

    public RegistrationPresenter(IRegistrationView view, UseCaseHandler handler) {
        this.view = view;
        this.handler = handler;
    }

    @Override
    public void start() {
        //Nothing on start
    }
}

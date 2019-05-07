package ru.nsu.bashev.modules.activities.registration;

import ru.nsu.bashev.common.useCaseEngine.IUseCaseCallback;
import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.modules.database.user.IUserDBHandler;
import ru.nsu.bashev.modules.useCases.SaveUser;

public class RegistrationPresenter implements IRegistrationPresenter {

    private IRegistrationView view;
    private UseCaseHandler handler;
    private IUserDBHandler userDBHandler;

    public RegistrationPresenter(IRegistrationView view, UseCaseHandler handler, IUserDBHandler userDBHandler) {
        this.view = view;
        this.handler = handler;
        this.userDBHandler = userDBHandler;
    }

    @Override
    public void start() {
        //Nothing on start
    }

    @Override
    public void saveUser(String name, String password) {
        if (name.isEmpty() || password.isEmpty()) {
            view.error();
        }
        SaveUser saveUser = new SaveUser(userDBHandler);
        SaveUser.RequestValues request = new SaveUser.RequestValues(name, password);
        handler.execute(saveUser, request, new IUseCaseCallback<SaveUser.ResponseValues>() {
            @Override
            public void onSuccess(SaveUser.ResponseValues response) {
                view.success();
            }

            @Override
            public void onError() {

            }
        });
    }
}

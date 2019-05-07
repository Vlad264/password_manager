package ru.nsu.bashev.modules.activities.enter;

import ru.nsu.bashev.common.useCaseEngine.IUseCaseCallback;
import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.modules.database.user.IUserDBHandler;
import ru.nsu.bashev.modules.useCases.CheckPassword;
import ru.nsu.bashev.modules.useCases.CheckUser;

public class EnterPresenter implements IEnterPresenter {

    private IEnterView view;
    private UseCaseHandler handler;
    private IUserDBHandler userDBHandler;

    public EnterPresenter(IEnterView view, UseCaseHandler handler, IUserDBHandler userDBHandler) {
        this.view = view;
        this.handler = handler;
        this.userDBHandler = userDBHandler;
    }

    @Override
    public void start() {
        CheckUser checkUser = new CheckUser(userDBHandler);
        CheckUser.RequestValues request = new CheckUser.RequestValues();
        handler.execute(checkUser, request, new IUseCaseCallback<CheckUser.ResponseValues>() {
            @Override
            public void onSuccess(CheckUser.ResponseValues response) {
                view.showName(response.getName());
            }

            @Override
            public void onError() {
                view.noRegistration();
            }
        });
    }

    @Override
    public void checkPassword(String password) {
        if (password.isEmpty()) {
            return;
        }

        CheckPassword checkPassword = new CheckPassword(userDBHandler);
        CheckPassword.RequestValues request = new CheckPassword.RequestValues(password);
        handler.execute(checkPassword, request, new IUseCaseCallback<CheckPassword.ResponseValues>() {
            @Override
            public void onSuccess(CheckPassword.ResponseValues response) {
                view.success();
            }

            @Override
            public void onError() {
                view.incorrectPassword();
            }
        });
    }
}

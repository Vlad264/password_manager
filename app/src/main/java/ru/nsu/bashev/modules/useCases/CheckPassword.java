package ru.nsu.bashev.modules.useCases;

import ru.nsu.bashev.common.useCaseEngine.UseCase;
import ru.nsu.bashev.model.User;
import ru.nsu.bashev.modules.database.user.IUserDBHandler;

public class CheckPassword extends UseCase<CheckPassword.RequestValues, CheckPassword.ResponseValues> {

    private final IUserDBHandler userDBHandler;

    public CheckPassword(IUserDBHandler userDBHandler) {
        this.userDBHandler = userDBHandler;
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        User user = userDBHandler.getUser();
        if (user.getPassword().equals(requestValues.getPassword())) {
            ResponseValues responseValues = new ResponseValues();
            getUseCaseCallback().onSuccess(responseValues);
        } else {
            getUseCaseCallback().onError();
        }
    }

    public static final class RequestValues implements UseCase.RequestValues {

        private String password;

        public RequestValues(String password) {
            this.password = password;
        }

        public String getPassword() {
            return password;
        }
    }

    public static final class ResponseValues implements UseCase.ResponseValues {

    }
}

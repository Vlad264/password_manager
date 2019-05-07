package ru.nsu.bashev.modules.useCases;

import ru.nsu.bashev.common.useCaseEngine.UseCase;
import ru.nsu.bashev.model.User;
import ru.nsu.bashev.modules.database.user.IUserDBHandler;

public class CheckUser extends UseCase<CheckUser.RequestValues, CheckUser.ResponseValues> {

    private final IUserDBHandler userDBHandler;

    public CheckUser(IUserDBHandler userDBHandler) {
        this.userDBHandler = userDBHandler;
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        if (userDBHandler.hasUser()) {
            ResponseValues responseValues = new ResponseValues(userDBHandler.getUser().getName());
            getUseCaseCallback().onSuccess(responseValues);
        } else {
            getUseCaseCallback().onError();
        }
    }

    public static final class RequestValues implements UseCase.RequestValues {

    }

    public static final class ResponseValues implements UseCase.ResponseValues {

        private String name;

        public ResponseValues(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}

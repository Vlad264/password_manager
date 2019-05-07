package ru.nsu.bashev.modules.useCases;

import ru.nsu.bashev.common.useCaseEngine.UseCase;
import ru.nsu.bashev.model.User;
import ru.nsu.bashev.modules.database.user.IUserDBHandler;

public class SaveUser extends UseCase<SaveUser.RequestValues, SaveUser.ResponseValues> {

    private final IUserDBHandler userDBHandler;

    public SaveUser(IUserDBHandler userDBHandler) {
        this.userDBHandler = userDBHandler;
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        userDBHandler.addUser(new User(requestValues.getName(), requestValues.getPassword()));
        ResponseValues responseValues = new ResponseValues();
        getUseCaseCallback().onSuccess(responseValues);
    }

    public static final class RequestValues implements UseCase.RequestValues {

        private String name;
        private String password;

        public RequestValues(String name, String password) {
            this.name = name;
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public String getPassword() {
            return password;
        }
    }

    public static final class ResponseValues implements UseCase.ResponseValues {

    }
}

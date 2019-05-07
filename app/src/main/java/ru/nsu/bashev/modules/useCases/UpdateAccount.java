package ru.nsu.bashev.modules.useCases;

import ru.nsu.bashev.common.useCaseEngine.UseCase;
import ru.nsu.bashev.model.Account;
import ru.nsu.bashev.modules.database.account.IAccountDBHandler;

public class UpdateAccount extends UseCase<UpdateAccount.RequestValues, UpdateAccount.ResponseValues> {

    private final IAccountDBHandler accountDBHandler;

    public UpdateAccount(IAccountDBHandler accountDBHandler) {
        this.accountDBHandler = accountDBHandler;
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        accountDBHandler.updateAccount(requestValues.getId(), requestValues.getAccount());
        getUseCaseCallback().onSuccess(new ResponseValues());
    }

    public static final class RequestValues implements UseCase.RequestValues {

        private long id;
        private Account account;

        public RequestValues(long id, Account account) {
            this.id = id;
            this.account = account;
        }

        public long getId() {
            return id;
        }

        public Account getAccount() {
            return account;
        }
    }

    public static final class ResponseValues implements UseCase.ResponseValues {

    }
}

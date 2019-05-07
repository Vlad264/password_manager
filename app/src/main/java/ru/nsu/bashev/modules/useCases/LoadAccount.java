package ru.nsu.bashev.modules.useCases;

import ru.nsu.bashev.common.useCaseEngine.UseCase;
import ru.nsu.bashev.model.Account;
import ru.nsu.bashev.modules.database.account.IAccountDBHandler;

public class LoadAccount extends UseCase<LoadAccount.RequestValues, LoadAccount.ResponseValues> {

    private final IAccountDBHandler accountDBHandler;

    public LoadAccount(IAccountDBHandler accountDBHandler) {
        this.accountDBHandler = accountDBHandler;
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        Account account = accountDBHandler.getAccount(requestValues.getId());
        if (account != null) {
            ResponseValues responseValues = new ResponseValues(account);
            getUseCaseCallback().onSuccess(responseValues);
        } else {
            getUseCaseCallback().onError();
        }
    }

    public static final class RequestValues implements UseCase.RequestValues {

        private long id;

        public RequestValues(long id) {
            this.id = id;
        }

        public long getId() {
            return id;
        }
    }

    public static final class ResponseValues implements UseCase.ResponseValues {

        private Account account;

        public ResponseValues(Account account) {
            this.account = account;
        }

        public Account getAccounts() {
            return account;
        }
    }
}

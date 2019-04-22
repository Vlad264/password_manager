package ru.nsu.bashev.modules.useCases;

import java.util.List;

import ru.nsu.bashev.common.useCaseEngine.UseCase;
import ru.nsu.bashev.model.Account;
import ru.nsu.bashev.modules.database.account.IAccountDBHandler;

public class SaveAccount extends UseCase<SaveAccount.RequestValues, SaveAccount.ResponseValues> {

    private final IAccountDBHandler accountDBHandler;

    public SaveAccount(IAccountDBHandler accountDBHandler) {
        this.accountDBHandler = accountDBHandler;
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        accountDBHandler.addAccount(requestValues.getAccount());
        getUseCaseCallback().onSuccess(new ResponseValues());
    }

    public static final class RequestValues implements UseCase.RequestValues {

        private Account account;

        public RequestValues(Account account) {
            this.account = account;
        }

        public Account getAccount() {
            return account;
        }
    }

    public static final class ResponseValues implements UseCase.ResponseValues {

    }
}

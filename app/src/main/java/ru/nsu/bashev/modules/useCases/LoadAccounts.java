package ru.nsu.bashev.modules.useCases;

import java.util.List;

import ru.nsu.bashev.common.useCaseEngine.UseCase;
import ru.nsu.bashev.model.Account;
import ru.nsu.bashev.modules.database.account.IAccountDBHandler;

public class LoadAccounts extends UseCase<LoadAccounts.RequestValues, LoadAccounts.ResponseValues> {

    private final IAccountDBHandler accountDBHandler;

    public LoadAccounts(IAccountDBHandler accountDBHandler) {
        this.accountDBHandler = accountDBHandler;
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        List<Account> accounts = accountDBHandler.getAllAccounts();
        if (accounts != null) {
            ResponseValues responseValues = new ResponseValues(accounts);
            getUseCaseCallback().onSuccess(responseValues);
        } else {
            getUseCaseCallback().onError();
        }
    }

    public static final class RequestValues implements UseCase.RequestValues {

    }

    public static final class ResponseValues implements UseCase.ResponseValues {

        private List<Account> accounts;

        public ResponseValues(List<Account> accounts) {
            this.accounts = accounts;
        }

        public List<Account> getAccounts() {
            return accounts;
        }
    }
}

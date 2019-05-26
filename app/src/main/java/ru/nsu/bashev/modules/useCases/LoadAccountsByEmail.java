package ru.nsu.bashev.modules.useCases;

import java.util.List;

import ru.nsu.bashev.common.useCaseEngine.UseCase;
import ru.nsu.bashev.model.Account;
import ru.nsu.bashev.model.Email;
import ru.nsu.bashev.modules.database.account.IAccountDBHandler;

public class LoadAccountsByEmail extends UseCase<LoadAccountsByEmail.RequestValues, LoadAccountsByEmail.ResponseValues> {

    private final IAccountDBHandler accountDBHandler;

    public LoadAccountsByEmail(IAccountDBHandler accountDBHandler) {
        this.accountDBHandler = accountDBHandler;
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        List<Account> accounts = accountDBHandler.getAccountsByEmail(new Email(requestValues.getEmail()));
        if (accounts != null && !accounts.isEmpty()) {
            ResponseValues responseValues = new ResponseValues(accounts);
            getUseCaseCallback().onSuccess(responseValues);
        } else {
            getUseCaseCallback().onError();
        }
    }

    public static final class RequestValues implements UseCase.RequestValues {

        private String email;

        public RequestValues(String email) {
            this.email = email;
        }

        public String getEmail() {
            return email;
        }
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

package ru.nsu.bashev.modules.useCases;

import java.util.List;

import ru.nsu.bashev.common.useCaseEngine.UseCase;
import ru.nsu.bashev.model.Account;
import ru.nsu.bashev.model.Email;
import ru.nsu.bashev.model.Login;
import ru.nsu.bashev.modules.database.account.IAccountDBHandler;

public class LoadAccountsByLogin extends UseCase<LoadAccountsByLogin.RequestValues, LoadAccountsByLogin.ResponseValues> {

    private final IAccountDBHandler accountDBHandler;

    public LoadAccountsByLogin(IAccountDBHandler accountDBHandler) {
        this.accountDBHandler = accountDBHandler;
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        List<Account> accounts = accountDBHandler.getAccountsByLogin(new Login(requestValues.getLogin()));
        if (accounts != null && !accounts.isEmpty()) {
            ResponseValues responseValues = new ResponseValues(accounts);
            getUseCaseCallback().onSuccess(responseValues);
        } else {
            getUseCaseCallback().onError();
        }
    }

    public static final class RequestValues implements UseCase.RequestValues {

        private String login;

        public RequestValues(String login) {
            this.login = login;
        }

        public String getLogin() {
            return login;
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

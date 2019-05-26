package ru.nsu.bashev.modules.useCases;

import java.util.List;

import ru.nsu.bashev.common.useCaseEngine.UseCase;
import ru.nsu.bashev.model.Account;
import ru.nsu.bashev.model.Category;
import ru.nsu.bashev.modules.database.account.IAccountDBHandler;

public class LoadAccountsByCategories extends UseCase<LoadAccountsByCategories.RequestValues, LoadAccountsByCategories.ResponseValues> {

    private final IAccountDBHandler accountDBHandler;

    public LoadAccountsByCategories(IAccountDBHandler accountDBHandler) {
        this.accountDBHandler = accountDBHandler;
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        List<Account> accounts = accountDBHandler.getAccountsByCategories(requestValues.getCategories());
        if (accounts != null) {
            ResponseValues responseValues = new ResponseValues(accounts);
            getUseCaseCallback().onSuccess(responseValues);
        } else {
            getUseCaseCallback().onError();
        }
    }

    public static final class RequestValues implements UseCase.RequestValues {

        private List<Category> categories;

        public RequestValues(List<Category> categories) {
            this.categories = categories;
        }

        public List<Category> getCategories() {
            return categories;
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

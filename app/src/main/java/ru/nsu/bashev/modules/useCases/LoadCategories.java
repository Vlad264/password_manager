package ru.nsu.bashev.modules.useCases;

import java.util.List;

import ru.nsu.bashev.common.useCaseEngine.UseCase;
import ru.nsu.bashev.model.Account;
import ru.nsu.bashev.model.Category;
import ru.nsu.bashev.modules.database.account.IAccountDBHandler;
import ru.nsu.bashev.modules.database.categories.ICategoriesDBHandler;

public class LoadCategories extends UseCase<LoadCategories.RequestValues, LoadCategories.ResponseValues> {

    private final ICategoriesDBHandler categoriesDBHandler;

    public LoadCategories(ICategoriesDBHandler categoriesDBHandler) {
        this.categoriesDBHandler = categoriesDBHandler;
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        List<Category> categories = categoriesDBHandler.getAll();
        if (categories != null) {
            ResponseValues responseValues = new ResponseValues(categories);
            getUseCaseCallback().onSuccess(responseValues);
        } else {
            getUseCaseCallback().onError();
        }
    }

    public static final class RequestValues implements UseCase.RequestValues {

    }

    public static final class ResponseValues implements UseCase.ResponseValues {

        private List<Category> categories;

        public ResponseValues(List<Category> accounts) {
            this.categories = accounts;
        }

        public List<Category> getCategories() {
            return categories;
        }
    }
}

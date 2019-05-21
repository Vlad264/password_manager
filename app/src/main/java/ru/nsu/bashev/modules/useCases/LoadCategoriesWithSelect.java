package ru.nsu.bashev.modules.useCases;

import java.util.List;

import ru.nsu.bashev.common.useCaseEngine.UseCase;
import ru.nsu.bashev.model.Category;
import ru.nsu.bashev.modules.database.account.IAccountDBHandler;
import ru.nsu.bashev.modules.database.categories.ICategoriesDBHandler;

public class LoadCategoriesWithSelect extends UseCase<LoadCategoriesWithSelect.RequestValues, LoadCategoriesWithSelect.ResponseValues> {

    private final IAccountDBHandler accountDBHandler;

    public LoadCategoriesWithSelect(IAccountDBHandler accountDBHandler) {
        this.accountDBHandler = accountDBHandler;
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        List<Category> categories = accountDBHandler.getAllWithSelectedCategories(requestValues.id);
        if (categories != null) {
            ResponseValues responseValues = new ResponseValues(categories);
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

        private List<Category> categories;

        public ResponseValues(List<Category> accounts) {
            this.categories = accounts;
        }

        public List<Category> getCategories() {
            return categories;
        }
    }
}

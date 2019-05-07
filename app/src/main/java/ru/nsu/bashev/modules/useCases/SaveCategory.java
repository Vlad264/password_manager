package ru.nsu.bashev.modules.useCases;

import ru.nsu.bashev.common.useCaseEngine.UseCase;
import ru.nsu.bashev.model.Account;
import ru.nsu.bashev.model.Category;
import ru.nsu.bashev.modules.database.account.IAccountDBHandler;
import ru.nsu.bashev.modules.database.categories.ICategoriesDBHandler;

public class SaveCategory extends UseCase<SaveCategory.RequestValues, SaveCategory.ResponseValues> {

    private final ICategoriesDBHandler categoriesDBHandler;

    public SaveCategory(ICategoriesDBHandler categoriesDBHandler) {
        this.categoriesDBHandler = categoriesDBHandler;
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        categoriesDBHandler.add(requestValues.getCategory());
        getUseCaseCallback().onSuccess(new ResponseValues());
    }

    public static final class RequestValues implements UseCase.RequestValues {

        private Category category;

        public RequestValues(Category category) {
            this.category = category;
        }

        public Category getCategory() {
            return category;
        }
    }

    public static final class ResponseValues implements UseCase.ResponseValues {

    }
}

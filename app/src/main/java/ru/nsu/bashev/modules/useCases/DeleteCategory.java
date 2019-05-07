package ru.nsu.bashev.modules.useCases;

import ru.nsu.bashev.common.useCaseEngine.UseCase;
import ru.nsu.bashev.modules.database.account.IAccountDBHandler;
import ru.nsu.bashev.modules.database.categories.ICategoriesDBHandler;

public class DeleteCategory extends UseCase<DeleteCategory.RequestValues, DeleteCategory.ResponseValues> {

    private final ICategoriesDBHandler categoriesDBHandler;

    public DeleteCategory(ICategoriesDBHandler categoriesDBHandler) {
        this.categoriesDBHandler = categoriesDBHandler;
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        categoriesDBHandler.delete(requestValues.getId());
        getUseCaseCallback().onSuccess(new ResponseValues());
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

    }
}

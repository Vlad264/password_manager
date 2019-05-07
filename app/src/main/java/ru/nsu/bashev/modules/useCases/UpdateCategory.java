package ru.nsu.bashev.modules.useCases;

import ru.nsu.bashev.common.useCaseEngine.UseCase;
import ru.nsu.bashev.model.Category;
import ru.nsu.bashev.modules.database.categories.ICategoriesDBHandler;

public class UpdateCategory extends UseCase<UpdateCategory.RequestValues, UpdateCategory.ResponseValues> {

    private final ICategoriesDBHandler categoriesDBHandler;

    public UpdateCategory(ICategoriesDBHandler categoriesDBHandler) {
        this.categoriesDBHandler = categoriesDBHandler;
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        categoriesDBHandler.update(requestValues.getId(), requestValues.getCategory());
        getUseCaseCallback().onSuccess(new ResponseValues());
    }

    public static final class RequestValues implements UseCase.RequestValues {

        private long id;
        private Category category;

        public RequestValues(long id, Category category) {
            this.id = id;
            this.category = category;
        }

        public long getId() {
            return id;
        }

        public Category getCategory() {
            return category;
        }
    }

    public static final class ResponseValues implements UseCase.ResponseValues {

    }
}

package ru.nsu.bashev.modules.useCases;

import java.util.List;

import ru.nsu.bashev.common.useCaseEngine.UseCase;
import ru.nsu.bashev.model.Category;
import ru.nsu.bashev.modules.database.categories.ICategoriesDBHandler;

public class LoadCategory extends UseCase<LoadCategory.RequestValues, LoadCategory.ResponseValues> {

    private final ICategoriesDBHandler categoriesDBHandler;

    public LoadCategory(ICategoriesDBHandler categoriesDBHandler) {
        this.categoriesDBHandler = categoriesDBHandler;
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        Category category = categoriesDBHandler.get(requestValues.getId());
        if (category != null) {
            ResponseValues responseValues = new ResponseValues(category);
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

        private Category category;

        public ResponseValues(Category category) {
            this.category = category;
        }

        public Category getCategory() {
            return category;
        }
    }
}

package ru.nsu.bashev.modules.useCases;

import java.util.Random;

import ru.nsu.bashev.common.useCaseEngine.UseCase;

public class HandlePush extends UseCase<HandlePush.RequestValues, HandlePush.ResponseValues> {

    private final Random random = new Random();

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        ResponseValues responseValues = new ResponseValues(random.nextInt(100) < 50);
        getUseCaseCallback().onSuccess(responseValues);
    }

    public static final class RequestValues implements UseCase.RequestValues {

    }

    public static final class ResponseValues implements UseCase.ResponseValues {

        private boolean flag;

        public ResponseValues(boolean flag) {
            this.flag = flag;
        }

        public boolean isFlag() {
            return flag;
        }
    }
}

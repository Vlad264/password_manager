package ru.nsu.bashev.common.useCaseEngine;

interface IUseCaseScheduler {
    void execute(Runnable runnable);

    <T extends UseCase.ResponseValues> void onResponse(T response, IUseCaseCallback<T> callback);
    <T extends UseCase.ResponseValues> void onError(IUseCaseCallback<T> callback);
}

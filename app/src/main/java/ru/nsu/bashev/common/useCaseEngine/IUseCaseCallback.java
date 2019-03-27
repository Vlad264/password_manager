package ru.nsu.bashev.common.useCaseEngine;

public interface IUseCaseCallback<T> {
    void onSuccess(T response);
    void onError();
}

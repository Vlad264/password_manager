package ru.nsu.bashev.modules.base;

public interface IBaseView<T extends IBasePresenter> {
    void setPresenter(T presenter);
}

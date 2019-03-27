package ru.nsu.bashev.modules.example;

import ru.nsu.bashev.modules.base.IBaseView;

public interface IExampleView extends IBaseView<IExamplePresenter> {
    void showToast(boolean flag);
}

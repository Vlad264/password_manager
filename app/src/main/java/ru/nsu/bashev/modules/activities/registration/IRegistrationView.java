package ru.nsu.bashev.modules.activities.registration;

import ru.nsu.bashev.modules.base.IBaseView;

public interface IRegistrationView extends IBaseView<IRegistrationPresenter> {
    void success();
    void error();
}

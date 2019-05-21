package ru.nsu.bashev.modules.activities.enter;

import ru.nsu.bashev.modules.base.IBaseView;

public interface IEnterView extends IBaseView<IEnterPresenter> {
    void showName(String name);
    void success();
    void incorrectPassword();
    void noRegistration();
}

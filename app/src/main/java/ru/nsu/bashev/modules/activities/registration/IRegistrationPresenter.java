package ru.nsu.bashev.modules.activities.registration;

import ru.nsu.bashev.modules.base.IBasePresenter;

public interface IRegistrationPresenter extends IBasePresenter {
    void saveUser(String name, String password);
}

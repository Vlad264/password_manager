package ru.nsu.bashev.modules.database.user;

import ru.nsu.bashev.model.User;

public interface IUserDBHandler {
    boolean hasUser();
    User getUser();
    void addUser(User user);
    void updateUser(User user);
    void deleteUser();
}

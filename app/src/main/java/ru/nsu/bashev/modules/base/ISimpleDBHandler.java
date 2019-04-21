package ru.nsu.bashev.modules.base;

import java.util.List;

public interface ISimpleDBHandler<T> {
    void add(T category);
    void update(int id, T category);
    T get(int id);
    List<T> getAll();
    void delete(int id);
    void deleteAll();
}

package ru.nsu.bashev.modules.base;

import java.util.List;

public interface ISimpleDBHandler<T> {
    void add(T value);
    void update(long id, T value);
    long has(T value);
    T get(long id);
    List<T> getAll();
    void delete(long id);
    void deleteAll();
}

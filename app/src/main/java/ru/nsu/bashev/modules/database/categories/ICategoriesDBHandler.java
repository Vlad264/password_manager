package ru.nsu.bashev.modules.database.categories;

import java.util.List;

import ru.nsu.bashev.model.Category;

public interface ICategoriesDBHandler {
    void addCategory(Category category);
    void updateCategory(int id, Category category);
    Category getCategory(int id);
    List<Category> getAllCategories();
    void deleteCategory(int id);
    void deleteAll();
}

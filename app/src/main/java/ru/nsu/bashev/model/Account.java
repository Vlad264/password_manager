package ru.nsu.bashev.model;

import java.util.List;

public class Account {
    private long id;
    private String name;
    private String description;
    private Password password;
    private Email email;
    private Login login;
    private List<Category> categories;

    boolean hasEmail = false;
    boolean hasLogin = false;

    public Account(String name, String description, Password password) {
        this.name = name;
        this.description = description;
        this.password = password;
    }

    public Account(long id, String name, String description, Password password, Email email, List<Category> categories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.password = password;
        this.email = email;
        hasEmail = true;
        this.categories = categories;
    }

    public Account(long id, String name, String description, Password password, Login login, List<Category> categories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.password = password;
        this.login = login;
        hasLogin = true;
        this.categories = categories;
    }

    public Account(long id, String name, String description, Password password, Email email, Login login, List<Category> categories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.password = password;
        this.email = email;
        hasEmail = true;
        this.login = login;
        hasLogin = true;
        this.categories = categories;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Password getPassword() {
        return password;
    }

    public Email getEmail() {
        return email;
    }

    public Login getLogin() {
        return login;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public boolean hasEmail() {
        return hasEmail;
    }

    public boolean hasLogin() {
        return hasLogin;
    }
}

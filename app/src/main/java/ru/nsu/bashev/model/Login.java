package ru.nsu.bashev.model;

public class Login {

    private long id;
    private String login;

    public Login(String login) {
        this.login = login;
    }

    public Login(long id, String login) {
        this.id = id;
        this.login = login;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }
}

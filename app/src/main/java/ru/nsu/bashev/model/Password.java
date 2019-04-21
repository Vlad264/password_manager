package ru.nsu.bashev.model;

public class Password {

    private long id;
    private String password;

    public Password(String password) {
        this.password = password;
    }

    public Password(long id, String password) {
        this.id = id;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}

package ru.nsu.bashev.model;

public class Email {

    private long id;
    private String email;

    public Email(String email) {
        this.email = email;
    }

    public Email(long id, String email) {
        this.id = id;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}

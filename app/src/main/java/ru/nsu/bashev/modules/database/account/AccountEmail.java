package ru.nsu.bashev.modules.database.account;

class AccountEmail {
    static final String TABLE_NAME = "account_email";
    static final String KEY_ACCOUNT_ID = "account_id";
    static final String KEY_EMAIL_ID = "email_id";

    static final String INSERT = "INSERT INTO " + TABLE_NAME + "(" + KEY_ACCOUNT_ID + "," + KEY_EMAIL_ID + ") VALUES(?,?)";
    static final String DELETE_ACCOUNT = "DELETE FROM " + TABLE_NAME + " WHERE " + KEY_ACCOUNT_ID + "=?";
    static final String DELETE_EMAIL = "DELETE FROM " + TABLE_NAME + " WHERE " + KEY_EMAIL_ID + "=?";
}

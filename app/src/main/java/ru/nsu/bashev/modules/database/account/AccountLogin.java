package ru.nsu.bashev.modules.database.account;

class AccountLogin {
    static final String TABLE_NAME = "account_login";
    static final String KEY_ACCOUNT_ID = "account_id";
    static final String KEY_LOGIN_ID = "login_id";

    static final String INSERT = "INSERT INTO " + TABLE_NAME + "(" + KEY_ACCOUNT_ID + "," + KEY_LOGIN_ID + ") VALUES(?,?)";
    static final String DELETE_ACCOUNT = "DELETE FROM " + TABLE_NAME + " WHERE " + KEY_ACCOUNT_ID + "=?";
    static final String DELETE_LOGIN = "DELETE FROM " + TABLE_NAME + " WHERE " + KEY_LOGIN_ID + "=?";
}

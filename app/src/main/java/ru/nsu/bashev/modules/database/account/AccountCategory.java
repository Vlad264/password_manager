package ru.nsu.bashev.modules.database.account;

class AccountCategory {
    static final String TABLE_NAME = "account_category";
    static final String KEY_ACCOUNT_ID = "account_id";
    static final String KEY_CATEGORY_ID = "category_id";

    static final String INSERT = "INSERT INTO " + TABLE_NAME + "(" + KEY_ACCOUNT_ID + "," + KEY_CATEGORY_ID + ") VALUES(?,?)";
    static final String DELETE_ACCOUNT = "DELETE FROM " + TABLE_NAME + " WHERE " + KEY_ACCOUNT_ID + "=?";
    static final String DELETE_CATEGORY = "DELETE FROM " + TABLE_NAME + " WHERE " + KEY_CATEGORY_ID + "=?";
}

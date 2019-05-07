package ru.nsu.bashev.modules.database.account;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

class AccountLogin {
    static final String TABLE_NAME = "account_login";
    static final String KEY_ACCOUNT_ID = "account_id";
    static final String KEY_LOGIN_ID = "login_id";

    static final String INSERT = "INSERT INTO " + TABLE_NAME + "(" + KEY_ACCOUNT_ID + "," + KEY_LOGIN_ID + ") VALUES(?,?)";
    static final String DELETE_ACCOUNT = "DELETE FROM " + TABLE_NAME + " WHERE " + KEY_ACCOUNT_ID + "=?";
    static final String DELETE_LOGIN = "DELETE FROM " + TABLE_NAME + " WHERE " + KEY_LOGIN_ID + "=?";

    static final String SELECT_ACCOUNT = "SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_ACCOUNT_ID + "=?";
    static final String SELECT_LOGIN = "SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_LOGIN_ID + "=?";
    static final String SELECT_ALL = "SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_ACCOUNT_ID + "=? AND " + KEY_LOGIN_ID + "=?";

    static boolean hasConnect(SQLiteDatabase db, long accountId, long loginId) {
        Cursor cursor = db.rawQuery(SELECT_ALL, new String[] { Long.toString(accountId), Long.toString(loginId) });
        if (cursor.moveToNext()) {
            cursor.close();
            return true;
        }
        cursor.close();
        return false;
    }

    static void addConnect(SQLiteDatabase db, long accountId, long loginId) {
        db.execSQL(INSERT, new String[] { Long.toString(accountId), Long.toString(loginId) });
    }

    static void deleteConnect(SQLiteDatabase db, long accountId) {
        db.execSQL(DELETE_ACCOUNT, new String[] { Long.toString(accountId) });
    }
}

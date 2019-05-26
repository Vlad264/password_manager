package ru.nsu.bashev.modules.database.account;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedList;
import java.util.List;

import ru.nsu.bashev.model.Login;
import ru.nsu.bashev.modules.database.email.EmailDBHandler;
import ru.nsu.bashev.modules.database.login.LoginDBHandler;

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

    static Login getLogin(SQLiteDatabase db, LoginDBHandler loginDBHandler, long id) {
        Cursor cursor = db.rawQuery(SELECT_ACCOUNT, new String[] { Long.toString(id)});
        if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        long loginId = Long.parseLong(cursor.getString(1));
        cursor.close();
        return loginDBHandler.get(loginId);
    }

    static List<Long> getAccounts(SQLiteDatabase db, long id) {
        List<Long> result = new LinkedList<>();
        Cursor cursor = db.rawQuery(SELECT_LOGIN, new String[] { Long.toString(id)});
        if (!cursor.moveToFirst()) {
            do {
                result.add(Long.parseLong(cursor.getString(0)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return result;
    }

    static void addConnect(SQLiteDatabase db, long accountId, long loginId) {
        db.execSQL(INSERT, new String[] { Long.toString(accountId), Long.toString(loginId) });
    }

    static void deleteConnect(SQLiteDatabase db, long accountId) {
        db.execSQL(DELETE_ACCOUNT, new String[] { Long.toString(accountId) });
    }
}

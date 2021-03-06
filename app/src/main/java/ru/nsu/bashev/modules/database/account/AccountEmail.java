package ru.nsu.bashev.modules.database.account;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedList;
import java.util.List;

import ru.nsu.bashev.model.Email;
import ru.nsu.bashev.modules.database.email.EmailDBHandler;

class AccountEmail {
    static final String TABLE_NAME = "account_email";
    static final String KEY_ACCOUNT_ID = "account_id";
    static final String KEY_EMAIL_ID = "email_id";

    static final String INSERT = "INSERT INTO " + TABLE_NAME + "(" + KEY_ACCOUNT_ID + "," + KEY_EMAIL_ID + ") VALUES(?,?)";
    static final String DELETE_ACCOUNT = "DELETE FROM " + TABLE_NAME + " WHERE " + KEY_ACCOUNT_ID + "=?";
    static final String DELETE_EMAIL = "DELETE FROM " + TABLE_NAME + " WHERE " + KEY_EMAIL_ID + "=?";

    static final String SELECT_ACCOUNT = "SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_ACCOUNT_ID + "=?";
    static final String SELECT_EMAIL = "SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_EMAIL_ID + "=?";
    static final String SELECT_ALL = "SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_ACCOUNT_ID + "=? AND " + KEY_EMAIL_ID + "=?";

    static boolean hasConnect(SQLiteDatabase db, long accountId, long emailId) {
        Cursor cursor = db.rawQuery(SELECT_ALL, new String[] { Long.toString(accountId), Long.toString(emailId) });
        if (cursor.moveToNext()) {
            cursor.close();
            return true;
        }
        cursor.close();
        return false;
    }

    static Email getEmail(SQLiteDatabase db, EmailDBHandler emailDBHandler, long id) {
        Cursor cursor = db.rawQuery(SELECT_ACCOUNT, new String[] { Long.toString(id)});
        if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        long emailId = Long.parseLong(cursor.getString(1));
        cursor.close();
        return emailDBHandler.get(emailId);
    }

    static List<Long> getAccounts(SQLiteDatabase db, long id) {
        List<Long> result = new LinkedList<>();
        Cursor cursor = db.rawQuery(SELECT_EMAIL, new String[] { Long.toString(id)});
        if (cursor.moveToFirst()) {
            do {
                result.add(Long.parseLong(cursor.getString(0)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return result;
    }

    static void addConnect(SQLiteDatabase db, long accountId, long emailId) {
        db.execSQL(INSERT, new String[] { Long.toString(accountId), Long.toString(emailId) });
    }

    static void deleteConnect(SQLiteDatabase db, long accountId) {
        db.execSQL(DELETE_ACCOUNT, new String[] { Long.toString(accountId) });
    }
}

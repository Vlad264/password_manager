package ru.nsu.bashev.modules.database.password;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

import ru.nsu.bashev.model.Password;
import ru.nsu.bashev.modules.base.ISimpleDBHandler;

public class PasswordDBHandler extends SQLiteOpenHelper implements ISimpleDBHandler<Password> {
    private static final int VERSION = 1;

    public static final String TABLE_NAME = "passwords";
    public static final String KEY_ID = "id";
    public static final String KEY_PASSWORD = "password";

    private static final String INSERT = "INSERT INTO " + TABLE_NAME + "(" + KEY_PASSWORD + ") VALUES(?)";
    private static final String UPDATE = "UPDATE " + TABLE_NAME + " SET " + KEY_PASSWORD + "=? WHERE " + KEY_ID + "=?";
    private static final String DELETE = "DELETE FROM " + TABLE_NAME + " WHERE " + KEY_ID + "=?";

    private static final String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;
    private static final String SELECT_ID = "SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_ID + "=?";
    private static final String SELECT_PASSWORD = "SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_PASSWORD + "=?";

    public PasswordDBHandler(Context context) {
        super(context, TABLE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + KEY_PASSWORD + " TEXT" + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void add(Password password) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(INSERT, new String[] { password.getPassword() });
        db.close();
    }

    @Override
    public void update(long id, Password password) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(UPDATE, new String[] { password.getPassword(), Long.toString(id) });
        db.close();
    }

    @Override
    public long has(Password password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(SELECT_PASSWORD, new String[] { password.getPassword() });
        if (cursor.moveToNext()) {
            long id = Long.parseLong(cursor.getString(0));
            cursor.close();
            db.close();
            return id;
        }
        cursor.close();
        db.close();
        return -1;
    }

    @Override
    public Password get(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(SELECT_ID, new String[] { Long.toString(id) });
        if (cursor.moveToNext()) {
            return new Password(Long.parseLong(cursor.getString(0)), cursor.getString(1));
        }
        cursor.close();
        db.close();
        return null;
    }

    @Override
    public List<Password> getAll() {
        List<Password> result = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(SELECT_ALL, null);
        if (cursor.moveToFirst()) {
            do {
                result.add(new Password(Long.parseLong(cursor.getString(0)), cursor.getString(1)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return result;
    }

    @Override
    public void delete(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(DELETE, new String[] { Long.toString(id) });
        db.close();
    }

    @Override
    public void deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, null, null);
        db.close();
    }
}

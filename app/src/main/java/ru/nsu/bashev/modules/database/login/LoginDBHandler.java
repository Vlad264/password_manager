package ru.nsu.bashev.modules.database.login;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

import ru.nsu.bashev.model.Login;
import ru.nsu.bashev.modules.base.ISimpleDBHandler;

public class LoginDBHandler extends SQLiteOpenHelper implements ISimpleDBHandler<Login> {
    private static final int VERSION = 1;
    private static final String TABLE_NAME = "login";
    private static final String KEY_ID = "id";
    private static final String KEY_LOGIN = "login";

    private static final String INSERT = "INSERT INTO " + TABLE_NAME + "(" + KEY_LOGIN + ") VALUES(?)";
    private static final String UPDATE = "UPDATE " + TABLE_NAME + " SET " + KEY_LOGIN + "=? WHERE " + KEY_ID + "=?";
    private static final String DELETE = "DELETE FROM " + TABLE_NAME + " WHERE " + KEY_ID + "=?";

    private static final String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;
    private static final String SELECT_ID = "SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_ID + "=?";

    public LoginDBHandler(Context context) {
        super(context, TABLE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + KEY_LOGIN + " TEXT" + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void add(Login category) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(INSERT, new String[] {category.getLogin()});
        db.close();
    }

    @Override
    public void update(int id, Login category) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(UPDATE, new String[] { category.getLogin(), Long.toString(id) });
        db.close();
    }

    @Override
    public Login get(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(SELECT_ID, new String[] { Long.toString(id) });
        if (cursor.moveToNext()) {
            return new Login(Long.parseLong(cursor.getString(0)), cursor.getString(1));
        }
        cursor.close();
        db.close();
        return null;
    }

    @Override
    public List<Login> getAll() {
        List<Login> result = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(SELECT_ALL, null);
        if (cursor.moveToFirst()) {
            do {
                result.add(new Login(Long.parseLong(cursor.getString(0)), cursor.getString(1)));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return result;
    }

    @Override
    public void delete(int id) {
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

package ru.nsu.bashev.modules.database.user;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ru.nsu.bashev.model.User;

public class UserDBHandler extends SQLiteOpenHelper implements IUserDBHandler {

    private static final int VERSION = 1;
    private static final String TABLE_NAME = "User";
    private static final String PASSWORD = "password";

    private static final String SELECT = "SELECT * FROM " + TABLE_NAME;

    public UserDBHandler(Context context) {
        super(context, TABLE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + PASSWORD + " TEXT" + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    @Override
    public boolean hasUser() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(SELECT, null);
        return cursor.moveToFirst();
    }

    @Override
    public User getUser() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(SELECT, null);
        if (cursor.moveToFirst()) {
            return new User(cursor.getString(0));
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PASSWORD, user.getPassword());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    @Override
    public void updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, null, null);
        ContentValues contentValues = new ContentValues();
        contentValues.put(PASSWORD, user.getPassword());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    @Override
    public void deleteUser() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, null, null);
        db.close();
    }
}

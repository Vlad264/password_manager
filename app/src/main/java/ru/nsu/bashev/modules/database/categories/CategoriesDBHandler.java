package ru.nsu.bashev.modules.database.categories;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

import ru.nsu.bashev.model.Category;

public class CategoriesDBHandler extends SQLiteOpenHelper implements ICategoriesDBHandler {
    private static final int VERSION = 1;
    private static final String TABLE_NAME = "Categories";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";

    private static final String INSERT = "INSERT INTO " + TABLE_NAME + "(" + KEY_NAME + ") VALUES(?)";
    private static final String UPDATE = "UPDATE " + TABLE_NAME + " SET " + KEY_NAME + "=? WHERE " + KEY_ID + "=?";
    private static final String DELETE = "DELETE FROM " + TABLE_NAME + " WHERE " + KEY_ID + "=?";

    private static final String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;
    private static final String SELECT_ID = "SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_ID + "=?";

    public CategoriesDBHandler(Context context) {
        super(context, TABLE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + KEY_NAME + " TEXT" + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void addCategory(Category category) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(INSERT, new String[] {category.getName()});
        db.close();
    }

    @Override
    public void updateCategory(int id, Category category) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(UPDATE, new String[] { category.getName(), Integer.toString(id) });
        db.close();
    }

    @Override
    public Category getCategory(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(SELECT_ID, new String[] { Integer.toString(id) });
        if (cursor.moveToNext()) {
            return new Category(Integer.parseInt(cursor.getString(0)), cursor.getString(1));
        }
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> result = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(SELECT_ALL, null);
        if (cursor.moveToFirst()) {
            do {
                result.add(new Category(Integer.parseInt(cursor.getString(0)), cursor.getString(1)));
            } while (cursor.moveToNext());
        }
        db.close();
        return result;
    }

    @Override
    public void deleteCategory(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(DELETE, new String[] { Integer.toString(id) });
        db.close();
    }

    @Override
    public void deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, null, null);
        db.close();
    }
}

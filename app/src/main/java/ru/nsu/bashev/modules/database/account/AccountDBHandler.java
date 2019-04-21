package ru.nsu.bashev.modules.database.account;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AccountDBHandler extends SQLiteOpenHelper implements IAccountDBHandler {
    private static final int VERSION = 1;

    private static final String TABLE_NAME = "accounts";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_DESC = "description";
    private static final String KEY_PASSWORD_ID = "password_id";

    public AccountDBHandler(Context context) {
        super(context, TABLE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE;
        CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + KEY_NAME + " TEXT" + ")";
        db.execSQL(CREATE_TABLE);

        CREATE_TABLE = "CREATE TABLE " + AccountCategory.TABLE_NAME + "("
                + AccountCategory.KEY_ACCOUNT_ID + " INTEGER NOT NULL,"
                + AccountCategory.KEY_CATEGORY_ID + " INTEGER NOT NULL,"
                + "PRIMARY KEY("+ AccountCategory.KEY_ACCOUNT_ID + "," + AccountCategory.KEY_CATEGORY_ID + "))";
        db.execSQL(CREATE_TABLE);

        CREATE_TABLE = "CREATE TABLE " + AccountEmail.TABLE_NAME + "("
                + AccountEmail.KEY_ACCOUNT_ID + " INTEGER NOT NULL,"
                + AccountEmail.KEY_EMAIL_ID + " INTEGER NOT NULL,"
                + "PRIMARY KEY("+ AccountEmail.KEY_ACCOUNT_ID + "," + AccountEmail.KEY_EMAIL_ID + "))";
        db.execSQL(CREATE_TABLE);

        CREATE_TABLE = "CREATE TABLE " + AccountLogin.TABLE_NAME + "("
                + AccountLogin.KEY_ACCOUNT_ID + " INTEGER NOT NULL,"
                + AccountLogin.KEY_LOGIN_ID + " INTEGER NOT NULL,"
                + "PRIMARY KEY("+ AccountLogin.KEY_ACCOUNT_ID + "," + AccountLogin.KEY_LOGIN_ID + "))";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + AccountCategory.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + AccountEmail.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + AccountLogin.TABLE_NAME);
        onCreate(db);
    }
}

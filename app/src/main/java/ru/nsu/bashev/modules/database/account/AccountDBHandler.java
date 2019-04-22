package ru.nsu.bashev.modules.database.account;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

import ru.nsu.bashev.model.Account;
import ru.nsu.bashev.model.Email;
import ru.nsu.bashev.model.Login;

public class AccountDBHandler extends SQLiteOpenHelper implements IAccountDBHandler {
    private static final int VERSION = 1;

    private static final String TABLE_NAME = "accounts";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_DESC = "description";
    private static final String KEY_PASSWORD_ID = "password_id";

    private static final String INSERT = "INSERT INTO " + TABLE_NAME + "(" + KEY_NAME + "," + KEY_DESC + "," + KEY_PASSWORD_ID + ") VALUES(?,?,?)";
    private static final String UPDATE = "UPDATE " + TABLE_NAME + " SET " + KEY_NAME + "=?," + KEY_DESC + "=?," + KEY_PASSWORD_ID + "=? WHERE " + KEY_ID + "=?";
    private static final String DELETE = "DELETE FROM " + TABLE_NAME + " WHERE " + KEY_ID + "=?";

    public AccountDBHandler(Context context) {
        super(context, TABLE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE;
        CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + KEY_NAME + " TEXT,"
                + KEY_DESC + " TEXT,"
                + KEY_PASSWORD_ID + " TEXT" + ")";
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

    @Override
    public void addAccount(Account account) {

    }

    @Override
    public void updateAccount(int id, Account account) {

    }

    @Override
    public List<Account> getAccount(int id) {
        return null;
    }

    @Override
    public List<Account> getAccountsByTitle(String titile) {
        return null;
    }

    @Override
    public List<Account> getAccountsByEmail(Email email) {
        return null;
    }

    @Override
    public List<Account> getAccountsByLogin(Login login) {
        return null;
    }

    @Override
    public List<Account> getAllAccounts() {
        return null;
    }

    @Override
    public void deleteAccount(int id) {

    }

    @Override
    public void deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, null, null);
        db.delete(AccountCategory.TABLE_NAME, null, null);
        db.delete(AccountEmail.TABLE_NAME, null, null);
        db.delete(AccountLogin.TABLE_NAME, null, null);
        db.close();
    }
}

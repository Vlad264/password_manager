package ru.nsu.bashev.modules.database.account;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

import ru.nsu.bashev.model.Account;
import ru.nsu.bashev.model.Category;
import ru.nsu.bashev.model.Email;
import ru.nsu.bashev.model.Login;
import ru.nsu.bashev.model.Password;
import ru.nsu.bashev.modules.database.categories.CategoriesDBHandler;
import ru.nsu.bashev.modules.database.email.EmailDBHandler;
import ru.nsu.bashev.modules.database.login.LoginDBHandler;
import ru.nsu.bashev.modules.database.password.PasswordDBHandler;

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

    private static final String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;
    private static final String SELECT_ID = "SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_ID + "=?";
    private static final String SELECT_NAME = "SELECT * FROM " + TABLE_NAME + " WHERE " + KEY_NAME + "=?";

    private CategoriesDBHandler categoriesDBHandler;
    private EmailDBHandler emailDBHandler;
    private LoginDBHandler loginDBHandler;
    private PasswordDBHandler passwordDBHandler;

    public AccountDBHandler(Context context) {
        super(context, TABLE_NAME, null, VERSION);
        categoriesDBHandler = new CategoriesDBHandler(context);
        emailDBHandler = new EmailDBHandler(context);
        loginDBHandler = new LoginDBHandler(context);
        passwordDBHandler = new PasswordDBHandler(context);
    }

    @Override
    public CategoriesDBHandler getCategoriesDBHandler() {
        return categoriesDBHandler;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE;
        CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + KEY_NAME + " TEXT,"
                + KEY_DESC + " TEXT,"
                + KEY_PASSWORD_ID + " TEXT,"
                + "FOREIGN KEY (" + KEY_PASSWORD_ID + ") REFERENCES " + PasswordDBHandler.TABLE_NAME + " (" + PasswordDBHandler.KEY_ID + "))";
        db.execSQL(CREATE_TABLE);

        CREATE_TABLE = "CREATE TABLE " + AccountCategory.TABLE_NAME + "("
                + AccountCategory.KEY_ACCOUNT_ID + " INTEGER NOT NULL,"
                + AccountCategory.KEY_CATEGORY_ID + " INTEGER NOT NULL,"
                + "PRIMARY KEY("+ AccountCategory.KEY_ACCOUNT_ID + "," + AccountCategory.KEY_CATEGORY_ID + "),"
                + "FOREIGN KEY (" + AccountCategory.KEY_ACCOUNT_ID + ") REFERENCES " + TABLE_NAME + " (" + KEY_ID + "),"
                + "FOREIGN KEY (" + AccountCategory.KEY_CATEGORY_ID + ") REFERENCES " + CategoriesDBHandler.TABLE_NAME + " (" + CategoriesDBHandler.KEY_ID + "))";
        db.execSQL(CREATE_TABLE);

        CREATE_TABLE = "CREATE TABLE " + AccountEmail.TABLE_NAME + "("
                + AccountEmail.KEY_ACCOUNT_ID + " INTEGER NOT NULL,"
                + AccountEmail.KEY_EMAIL_ID + " INTEGER NOT NULL,"
                + "PRIMARY KEY("+ AccountEmail.KEY_ACCOUNT_ID + "," + AccountEmail.KEY_EMAIL_ID + "),"
                + "FOREIGN KEY (" + AccountEmail.KEY_ACCOUNT_ID + ") REFERENCES " + TABLE_NAME + " (" + KEY_ID + "),"
                + "FOREIGN KEY (" + AccountEmail.KEY_EMAIL_ID + ") REFERENCES " + EmailDBHandler.TABLE_NAME + " (" + EmailDBHandler.KEY_ID + "))";
        db.execSQL(CREATE_TABLE);

        CREATE_TABLE = "CREATE TABLE " + AccountLogin.TABLE_NAME + "("
                + AccountLogin.KEY_ACCOUNT_ID + " INTEGER NOT NULL,"
                + AccountLogin.KEY_LOGIN_ID + " INTEGER NOT NULL,"
                + "PRIMARY KEY("+ AccountLogin.KEY_ACCOUNT_ID + "," + AccountLogin.KEY_LOGIN_ID + "),"
                + "FOREIGN KEY (" + AccountLogin.KEY_ACCOUNT_ID + ") REFERENCES " + TABLE_NAME + " (" + KEY_ID + "),"
                + "FOREIGN KEY (" + AccountLogin.KEY_LOGIN_ID + ") REFERENCES " + LoginDBHandler.TABLE_NAME + " (" + LoginDBHandler.KEY_ID + "))";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + AccountCategory.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + AccountEmail.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + AccountLogin.TABLE_NAME);
        categoriesDBHandler.onUpgrade(categoriesDBHandler.getWritableDatabase(), oldVersion, newVersion);
        emailDBHandler.onUpgrade(emailDBHandler.getWritableDatabase(), oldVersion, newVersion);
        loginDBHandler.onUpgrade(loginDBHandler.getWritableDatabase(), oldVersion, newVersion);
        passwordDBHandler.onUpgrade(passwordDBHandler.getWritableDatabase(), oldVersion, newVersion);
        onCreate(db);
    }

    @Override
    public void addAccount(Account account) {
        long password_id = passwordDBHandler.has(account.getPassword());
        if (password_id == -1) {
            passwordDBHandler.add(account.getPassword());
            password_id = passwordDBHandler.has(account.getPassword());
        }
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME, account.getName());
        contentValues.put(KEY_DESC, account.getDescription());
        contentValues.put(KEY_PASSWORD_ID, password_id);
        long id = db.insert(TABLE_NAME, null, contentValues);

        for (Category c : account.getCategories()) {
            AccountCategory.addConnect(db, id, c.getId());
        }
        if (account.hasEmail()) {
            long emailId = emailDBHandler.has(account.getEmail());
            if (emailId == -1) {
                emailDBHandler.add(account.getEmail());
            }
            AccountEmail.addConnect(db, id, emailId);
        }
        if (account.hasLogin()) {
            long loginId = loginDBHandler.has(account.getLogin());
            if (loginId == -1) {
                loginDBHandler.add(account.getLogin());
            }
            AccountLogin.addConnect(db, id, loginId);
        }
        db.close();
    }

    @Override
    public void updateAccount(long id, Account account) {
        SQLiteDatabase db = this.getWritableDatabase();
        long password_id = passwordDBHandler.has(account.getPassword());
        if (password_id == -1) {
            passwordDBHandler.add(account.getPassword());
            password_id = passwordDBHandler.has(account.getPassword());
        }
        db.execSQL(UPDATE, new String[] { account.getName(), account.getDescription(), Long.toString(password_id), Long.toString(id)});
        AccountCategory.deleteConnect(db, id);
        for (Category c : account.getCategories()) {
            AccountCategory.addConnect(db, id, c.getId());
        }
        AccountEmail.deleteConnect(db, id);
        if (account.hasEmail()) {
            long emailId = emailDBHandler.has(account.getEmail());
            if (emailId == -1) {
                emailDBHandler.add(account.getEmail());
            }
            AccountEmail.addConnect(db, id, emailId);
        }
        AccountLogin.deleteConnect(db, id);
        if (account.hasLogin()) {
            long loginId = loginDBHandler.has(account.getLogin());
            if (loginId == -1) {
                loginDBHandler.add(account.getLogin());
            }
            AccountLogin.addConnect(db, id, loginId);
        }
        db.close();
    }

    @Override
    public Account getAccount(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(SELECT_ID, new String[] { Long.toString(id)});
        if (cursor.moveToFirst()) {
            Password  password = passwordDBHandler.get(Long.parseLong(cursor.getString(3)));
            Email email = AccountEmail.getEmail(db, emailDBHandler, id);
            Login login = AccountLogin.getLogin(db, loginDBHandler, id);
            List<Category> categories = AccountCategory.getCategories(db, categoriesDBHandler, id);
            Account result = new Account(Long.parseLong(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    password,
                    email,
                    login,
                    categories);
            cursor.close();
            db.close();
            return result;
        }
        cursor.close();
        db.close();
        return null;
    }

    @Override
    public List<Category> getAllWithSelectedCategories(long id) {
        List<Category> result = categoriesDBHandler.getAll();
        SQLiteDatabase db = this.getWritableDatabase();
        List<Category> selected = AccountCategory.getCategories(db, categoriesDBHandler, id);
        db.close();
        for (Category c : selected) {
            for (Category r : result) {
                if (c.getId() == r.getId()) {
                    r.setSelected(true);
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public List<Account> getAccountsByTitle(String title) {
        List<Account> result = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(SELECT_NAME, new String[] { title });
        if (cursor.moveToFirst()) {
            do {
                long id = Long.parseLong(cursor.getString(0));
                Password  password = passwordDBHandler.get(Long.parseLong(cursor.getString(3)));
                Email email = AccountEmail.getEmail(db, emailDBHandler, id);
                Login login = AccountLogin.getLogin(db, loginDBHandler, id);
                List<Category> categories = AccountCategory.getCategories(db, categoriesDBHandler, id);
                result.add(new Account(id,
                        cursor.getString(1),
                        cursor.getString(2),
                        password,
                        email,
                        login,
                        categories));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return result;
    }

    @Override
    public List<Account> getAccountsByEmail(Email email) {
        List<Account> result = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        long emailId = emailDBHandler.has(email);
        if (emailId != -1) {
            List<Long> accounts = AccountEmail.getAccounts(db, emailDBHandler, emailId);
            for (long i : accounts) {
                result.add(getAccount(i));
            }
        }
        db.close();
        return result;
    }

    @Override
    public List<Account> getAccountsByLogin(Login login) {
        List<Account> result = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        long loginId = loginDBHandler.has(login);
        if (loginId != -1) {
            List<Long> accounts = AccountEmail.getAccounts(db, emailDBHandler, loginId);
            for (long i : accounts) {
                result.add(getAccount(i));
            }
        }
        db.close();
        return result;
    }

    @Override
    public List<Account> getAllAccounts() {
        List<Account> result = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(SELECT_ALL, null);
        if (cursor.moveToFirst()) {
            do {
                long id = Long.parseLong(cursor.getString(0));
                Password  password = passwordDBHandler.get(Long.parseLong(cursor.getString(3)));
                Email email = AccountEmail.getEmail(db, emailDBHandler, id);
                Login login = AccountLogin.getLogin(db, loginDBHandler, id);
                List<Category> categories = AccountCategory.getCategories(db, categoriesDBHandler, id);
                result.add(new Account(id,
                        cursor.getString(1),
                        cursor.getString(2),
                        password,
                        email,
                        login,
                        categories));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return result;
    }

    @Override
    public void deleteAccount(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(DELETE, new String[] { Long.toString(id) });
        AccountCategory.deleteConnect(db, id);
        AccountEmail.deleteConnect(db, id);
        AccountLogin.deleteConnect(db, id);
    }

    @Override
    public void deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, null, null);
        db.delete(AccountCategory.TABLE_NAME, null, null);
        db.delete(AccountEmail.TABLE_NAME, null, null);
        db.delete(AccountLogin.TABLE_NAME, null, null);
        categoriesDBHandler.deleteAll();
        emailDBHandler.deleteAll();
        loginDBHandler.deleteAll();
        passwordDBHandler.deleteAll();
        db.close();
    }
}

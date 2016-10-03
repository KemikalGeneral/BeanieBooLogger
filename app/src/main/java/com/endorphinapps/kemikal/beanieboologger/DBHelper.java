package com.endorphinapps.kemikal.beanieboologger;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by KeMiKaL on 29/09/2016.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "beanieDB";
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_NAME = "beanies";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_IMAGE = "image";
    private static final String COLUMN_IS_OWNED = "isOwned";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "( " +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " VARCHAR, " +
                COLUMN_IMAGE + " INTEGER, " +
                COLUMN_IS_OWNED + " INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insert(String name, Integer image) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_IMAGE, image);
        db.insert(TABLE_NAME, null, values);
    }

    public ArrayList<Item> selectAllWithArray() {
        ArrayList<Item> beanies = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        Cursor record = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (record.moveToFirst()) {
            while (record.moveToNext()) {
                Item item = new Item();
                item.set_id(Integer.parseInt(record.getString(0)));
                item.setName(record.getString(1));
                item.setImage(record.getInt(2));
                beanies.add(item);
            }
        }
        return beanies;
    }

    public void update(String name, Integer isOwned) {
        Log.v("z!", name);
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_IS_OWNED, isOwned);
        db.update(TABLE_NAME, values, COLUMN_NAME + " = " + name, null);
    }

    public Cursor selectAllWithCursor() {
        ArrayList<Item> beanies = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        Cursor record = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (record.moveToFirst()) {
            while (record.moveToNext()) {
                Item item = new Item();
                item.set_id(Integer.parseInt(record.getString(0)));
                item.setName(record.getString(1));
                item.setImage(record.getInt(2));
                beanies.add(item);
            }
        }
        return record;
    }

    public void deleteTable(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public int numberOfRows() {
        SQLiteDatabase db = getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        return numRows;
    }

    public String getDatabaseName() {
        return DATABASE_NAME;
    }
}

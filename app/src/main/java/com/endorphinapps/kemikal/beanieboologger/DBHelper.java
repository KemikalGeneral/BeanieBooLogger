package com.endorphinapps.kemikal.beanieboologger;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by KeMiKaL on 29/09/2016.
 */

/**
 * DataBase helper class that contains all the CRUD methods
 **/

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "beanieDB";
    private static final int DATABASE_VERSION = 3;
    private static final String TABLE_NAME = "beanies";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_IMAGE = "image";
    private static final String COLUMN_BIRTHDAY = "birthday";
    private static final String COLUMN_IS_OWNED = "isOwned";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Create and Set-Up database
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "( " +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " VARCHAR UNIQUE, " +
                COLUMN_IMAGE + " INTEGER, " +
                COLUMN_BIRTHDAY + " VARCHAR, " +
                COLUMN_IS_OWNED + " INT);");
    }

    //OnUpgrade - Drop and Create table
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //Insert new items with name and image
    public void insert(String name, Integer image) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_IMAGE, image);
        db.insert(TABLE_NAME, null, values);
    }

    //Retrieve all records from table into an ArrayList
    public ArrayList<Item> selectAllWithArray() {
        ArrayList<Item> beanies = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        Cursor record = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        //Cycle through the cursor and create a new Beanie Items
        if (record.moveToFirst()) {
            while (record.moveToNext()) {
                Item item = new Item();
                item.set_id(Integer.parseInt(record.getString(record.getColumnIndex(COLUMN_ID))));
                item.setName(record.getString(record.getColumnIndex(COLUMN_NAME)));
                item.setImage(record.getInt(record.getColumnIndex(COLUMN_IMAGE)));
                item.setBirthday(record.getString(record.getColumnIndex(COLUMN_BIRTHDAY)));
                item.setIsOwned(record.getInt(record.getColumnIndex(COLUMN_IS_OWNED)));
                //Add to array of Beanies
                beanies.add(item);
            }
        }
        record.close();
        return beanies;
    }

    //Return isOwned for use in the mainActivity
    public int getIsOwned(int id) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT  * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = " + id, null);
        int isOwned = 1;
        if (cursor.moveToFirst()) {
            isOwned = cursor.getInt(cursor.getColumnIndex(COLUMN_IS_OWNED));
        }
        cursor.close();

        return isOwned;
    }

    //Update table 'isOwned' field 0=false 1=true
    public void updateIsOwned(Integer id, int isOwned) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_IS_OWNED, isOwned);
        db.update(TABLE_NAME, values, COLUMN_ID + " = " + id, null);
    }

    //Update table 'birthday' field 0=false 1=true
    public void updateBirthday(Integer id, String birthday) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_BIRTHDAY, birthday);
        db.update(TABLE_NAME, values, COLUMN_ID + " = " + id, null);
    }

    //Drop table
    public void deleteTable(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    //Return the number of rown in the table
    public int numberOfRows() {
        SQLiteDatabase db = getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        return numRows;
    }

    //Return the name of the database
    public String getDatabaseName() {
        return DATABASE_NAME;
    }
}

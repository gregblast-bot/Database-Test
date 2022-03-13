package com.sandipbhattacharya.databasedemo;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAdapter {

    DatabaseHelper helper;
    SQLiteDatabase db;
    List<Contacts> contactsList = new ArrayList<>();

    public DatabaseAdapter(Context context) {
        helper = new DatabaseHelper(context);
        db = helper.getWritableDatabase();
    }

    public List<Contacts> getAllContacts(){
        String columns[] = {DatabaseHelper.KEY_LATIN_NAME, DatabaseHelper.KEY_FAMILY, DatabaseHelper.KEY_COMMON_NAME};
        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME, columns,null, null,null, null, null, null);
        while(cursor.moveToNext()){
            int index1 = cursor.getColumnIndex(DatabaseHelper.KEY_FAMILY);
            String family = cursor.getString(index1);
            int index2 = cursor.getColumnIndex(DatabaseHelper.KEY_COMMON_NAME);
            String common_name = cursor.getString(index2);
            int index3 = cursor.getColumnIndex(DatabaseHelper.KEY_LATIN_NAME);
            String latin_name = cursor.getString(index3);
            Contacts contact = new Contacts(latin_name, family, common_name);
            contactsList.add(contact);
        }
        return contactsList;
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "mydb.db";
        private static final String TABLE_NAME = "Database_Temperate";
        // When you do change the structure of the database change the version number from 1 to 2
        private static final int DATABASE_VERSION = 2;
        private static final String KEY_LATIN_NAME="Latin_name";
        private static final String KEY_FAMILY = "Family";
        private static final String KEY_COMMON_NAME = "Common_name";
        private static final String CREATE_TABLE = "create table "+ TABLE_NAME+
                " ("+ KEY_LATIN_NAME+" text, "+ KEY_FAMILY + " text, "+ KEY_COMMON_NAME+ " text)";
        private static final String DROP_TABLE = "drop table if exists "+ TABLE_NAME;
        private Context context;

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
            Toast.makeText(context, "constructor called", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try{
                //db.execSQL(CREATE_TABLE);
                Toast.makeText(context, "onCreate called", Toast.LENGTH_SHORT).show();
            }catch (SQLException e){
                Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try{
                Toast.makeText(context, "onUpgrade called", Toast.LENGTH_SHORT).show();
                //db.execSQL(DROP_TABLE);
                //onCreate(db);
            }catch (SQLException e){
                Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
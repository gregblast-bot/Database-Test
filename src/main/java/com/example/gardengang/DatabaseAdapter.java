package com.example.gardengang;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class DatabaseAdapter {

    DatabaseHelper helper;
    SQLiteDatabase db;
    Context context;

    public DatabaseAdapter(Context context) {
        helper = new DatabaseHelper(context);
        db = helper.getWritableDatabase();
        this.context = context;
    }

    public SimpleCursorAdapter populateListViewFromDB(){
        String columns[] = {DatabaseHelper.KEY_ROWID, DatabaseHelper.KEY_CNAME, DatabaseHelper.KEY_LNAME,
                DatabaseHelper.KEY_FAM, DatabaseHelper.KEY_HABITAT, DatabaseHelper.KEY_HABIT,
                DatabaseHelper.KEY_HARD, DatabaseHelper.KEY_SOIL, DatabaseHelper.KEY_SHADE,
                DatabaseHelper.KEY_MOIST, DatabaseHelper.KEY_PH, DatabaseHelper.KEY_MED
        };

        Cursor cursor = db.query(DatabaseHelper.TABLE_NAME, columns,null, null,null, null, null, null);
        String[] fromFieldNames = new String[]{
                DatabaseHelper.KEY_ROWID, DatabaseHelper.KEY_CNAME, DatabaseHelper.KEY_LNAME,
                DatabaseHelper.KEY_FAM, DatabaseHelper.KEY_HABITAT, DatabaseHelper.KEY_HABIT,
                DatabaseHelper.KEY_HARD, DatabaseHelper.KEY_SOIL, DatabaseHelper.KEY_SHADE,
                DatabaseHelper.KEY_MOIST, DatabaseHelper.KEY_PH, DatabaseHelper.KEY_MED
        };

        int[] toViewIDs = new int[]{R.id.item_id, R.id.item_common_name, R.id.item_latin_name};
        SimpleCursorAdapter contactAdapter = new SimpleCursorAdapter(
                context,
                R.layout.single_item,
                cursor,
                fromFieldNames,
                toViewIDs
        );
        return contactAdapter;
    }

    public Cursor getAllSuggestedValues (CharSequence constraint)  {
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(
                DatabaseHelper.TABLE_NAME
        );

        String columns[] = {DatabaseHelper.TABLE_NAME + "."
                + DatabaseHelper.KEY_ROWID + ","
                + DatabaseHelper.TABLE_NAME + "."
                + DatabaseHelper.KEY_CNAME + ","
                + DatabaseHelper.TABLE_NAME + "."
                + DatabaseHelper.KEY_LNAME + ","
                + DatabaseHelper.TABLE_NAME + "."
                + DatabaseHelper.KEY_FAM + ","
                + DatabaseHelper.TABLE_NAME + "."
                + DatabaseHelper.KEY_HABITAT + ","
                + DatabaseHelper.TABLE_NAME + "."
                + DatabaseHelper.KEY_HABIT + ","
                + DatabaseHelper.TABLE_NAME + "."
                + DatabaseHelper.KEY_HARD + ","
                + DatabaseHelper.TABLE_NAME + "."
                + DatabaseHelper.KEY_SOIL + ","
                + DatabaseHelper.TABLE_NAME + "."
                + DatabaseHelper.KEY_SHADE + ","
                + DatabaseHelper.TABLE_NAME + "."
                + DatabaseHelper.KEY_MOIST + ","
                + DatabaseHelper.TABLE_NAME + "."
                + DatabaseHelper.KEY_PH + ","
                + DatabaseHelper.TABLE_NAME + "."
                + DatabaseHelper.KEY_MED
        };

        if (constraint == null  ||  constraint.length () == 0)  {
            //  Return the full list
            return db.query(DatabaseHelper.TABLE_NAME, columns,null, null,null, null, null, null);
        }
        else{
            String value = "%"+constraint.toString()+"%";
            return db.query(DatabaseHelper.TABLE_NAME, columns, "Common_name like ? ", new String[]{value}, null, null, null);
        }
    }

    public void populateGarden(long id, String common_name, String latin_name) {
        Toast.makeText(context, "Adding Plant to My Garden!", Toast.LENGTH_SHORT).show();
    }

    static class DatabaseHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "mydb.db";
        public static final String TABLE_NAME = "Database_Temperate";
        // When you do change the structure of the database change the version number from 1 to 2
        private static final int DATABASE_VERSION = 2;
        private static final String KEY_ROWID = "_id";
        public static final String KEY_CNAME="Common_name";
        public static final String KEY_LNAME = "Latin_name";
        private static final String KEY_FAM = "Family";
        private static final String KEY_HABITAT = "Habitat";
        private static final String KEY_HABIT = "Habit";
        private static final String KEY_HARD = "UK_Hardiness";
        private static final String KEY_SOIL = "Soil";
        private static final String KEY_SHADE = "Shade";
        private static final String KEY_MOIST = "Moisture";
        private static final String KEY_PH = "pH";
        private static final String KEY_MED = "Medicinal";
        private static final String CREATE_TABLE = "create table "+ TABLE_NAME+
                " ("+ KEY_ROWID+" integer primary key autoincrement, "+ KEY_CNAME + " text, "+ KEY_LNAME+ " text, "
                + KEY_FAM + " text, " + KEY_HABITAT + " text, " + KEY_HABIT + " text, "
                + KEY_HARD + " integer, " + KEY_SOIL + " text, "+ KEY_SHADE + " text, "
                + KEY_MOIST + " text, " + KEY_PH + " text, " + KEY_MED+ " text)";
        private static final String DROP_TABLE = "drop table if exists "+ TABLE_NAME;
        private Context context;

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
            //Toast.makeText(context, "constructor called", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try{
                db.execSQL(CREATE_TABLE);
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
//        public int updateEmailNew(long id, String latin_name) {
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(DatabaseHelper.KEY_LNAME, latin_name);
//        String whereArgs[] = {""+id};
//        int count = db.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper.KEY_ROWID+ "=?", whereArgs);
//        return count;
//    }
}

package com.alperencan.habittracker.android.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.alperencan.habittracker.android.data.HabitContract.HabitEntry;

/**
 * Database helper for HabitTracker app. Manages database creation and version management.
 */

public class HabitTrackerDbHelper extends SQLiteOpenHelper {

    /**
     * Name of the database file
     */
    private static final String DATABASE_NAME = "HabitTracker.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of {@link HabitTrackerDbHelper}
     *
     * @param context of the app
     */
    public HabitTrackerDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     *
     * @param sqLiteDatabase database being created
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Create a String that contains the SQL statement to create the habits table
        String SQL_CREATE_HABITS_TABLE = "CREATE TABLE " + HabitEntry.TABLE_NAME + " ("
                + HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitEntry.COLUMN_HABIT_NAME + " TEXT NOT NULL, "
                + HabitEntry.COLUMN_HABIT_TYPE + " INTEGER NOT NULL DEFAULT 0);";

        // Execute the SQL statement
        sqLiteDatabase.execSQL(SQL_CREATE_HABITS_TABLE);
    }

    /**
     * This is called when the database needs to be upgraded.
     * @param sqLiteDatabase database being upgraded
     * @param oldVersion old database version number
     * @param newVersion new database version number
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }
}
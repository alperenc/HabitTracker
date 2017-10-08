package com.alperencan.habittracker.android;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alperencan.habittracker.android.data.HabitContract.HabitEntry;
import com.alperencan.habittracker.android.data.HabitTrackerDbHelper;

public class HabitTrackerActivity extends AppCompatActivity {

    /**
     * Database helper that will provide us access to the database
     */
    private HabitTrackerDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_tracker);

        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.
        dbHelper = new HabitTrackerDbHelper(this);
    }

    /**
     * Helper method to insert hardcoded habit data into the database.
     */
    private void insertHabit() {
        // Gets the database in write mode
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Create a ContentValues object where column names are the keys,
        // and habit attributes are the values.
        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_HABIT_NAME, "Learn to code");
        values.put(HabitEntry.COLUMN_HABIT_TYPE, HabitEntry.TYPE_INTELLECTUAL);

        // Insert a new row for habit in the database, returning the ID of that new row.
        // The first argument for db.insert() is the habits table name.
        // The second argument provides the name of a column in which the framework
        // can insert NULL in the event that the ContentValues is empty (if
        // this is set to "null", then the framework will not insert a row when
        // there are no values).
        // The third argument is the ContentValues object containing the info for the habit.
        long newRowId = db.insert(HabitEntry.TABLE_NAME, null, values);
    }

    /**
     * Helper method to read hardcoded habit data from the database.
     */
    private Cursor readHabits() {
        // Create and/or open a database to read from it
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                HabitEntry._ID,
                HabitEntry.COLUMN_HABIT_NAME,
                HabitEntry.COLUMN_HABIT_TYPE
        };

        // Perform a query on the habits table
        Cursor cursor = db.query(
                HabitEntry.TABLE_NAME,   // The table to query
                projection,            // The columns to return
                null,                  // The columns for the WHERE clause
                null,                  // The values for the WHERE clause
                null,                  // Don't group the rows
                null,                  // Don't filter by row groups
                null                   // The sort order
        );

        return cursor;
    }
}
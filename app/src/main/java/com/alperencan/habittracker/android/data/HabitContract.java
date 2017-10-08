package com.alperencan.habittracker.android.data;

import android.provider.BaseColumns;

/**
 * API Contract for the HabitTracker app.
 */

public final class HabitContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private HabitContract() {}

    /**
     * Inner class that defines constant values for the habits database table.
     * Each entry in the table represents a single habit.
     */
    public static final class HabitEntry implements BaseColumns {

        /** Name of database table for habits */
        public final static String TABLE_NAME = "habits";

        /**
         * Unique ID number for the habit (only for use in the database table).
         *
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Name of the habit.
         *
         * Type: TEXT
         */
        public final static String COLUMN_HABIT_NAME ="name";

        /**
         * Type of the habit.
         *
         * TYPE: INTEGER
         */
        public final static String COLUMN_HABIT_TYPE = "type";

        /**
         * Possible values for the type of the habit.
         */
        public static final int TYPE_UNCATEGORIZED = 0;
        public static final int TYPE_MOTOR = 1;
        public static final int TYPE_INTELLECTUAL = 2;
        public static final int TYPE_EMOTIONAL = 3;
    }
}

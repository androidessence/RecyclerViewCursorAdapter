package com.androidessence.recyclerviewcursoradapter.sample.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Creates the SQLiteDatabase to handle movies.
 *
 * Created by adammcneilly on 12/8/15.
 */
class MovieDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "recyclerviewcursoradaptersample.db";
    private static final int DATABASE_VERSION = 1;

    public MovieDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create table
        db.execSQL(
                "CREATE TABLE " + MovieContract.MovieEntry.TABLE_NAME + " (" +
                        MovieContract.MovieEntry._ID + " INTEGER PRIMARY KEY, " +
                        MovieContract.MovieEntry.COLUMN_NAME + " TEXT UNIQUE NOT NULL);"
        );

        // Insert sample data
        db.execSQL(
                "INSERT INTO " + MovieContract.MovieEntry.TABLE_NAME + " (" + MovieContract.MovieEntry.COLUMN_NAME + ") VALUES " +
                        "('Harry Potter and the Sorcerer''s Stone'), ('Harry Potter and the Chamber of Secrets'), ('Harry Potter and the Prisoner of Azkaban'), ('Harry Potter and the Goblet of Fire'), ('Harry Potter and the Order of the Phoenix'), ('Harry Potter and the Half Blood Prince'), ('Harry Potter and the Deathly Hallows');"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}



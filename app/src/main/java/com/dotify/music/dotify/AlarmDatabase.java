package com.dotify.music.dotify;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class AlarmDatabase extends SQLiteOpenHelper {

    private static final String TAG = "AlarmDatabase";

    private static final String TABLE_NAME = "Alarm";
    private static final String ID = "AlarmId";
    private static final String COL1 = "Hour";
    private static final String COL2 = "Minute";

    public AlarmDatabase(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME
                + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL1 +" INTEGER NOT NULL, "
                + COL2 + " INTEGER NOT NULL)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addAlarm(int hour, int minute) {
       SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, hour);
        contentValues.put(COL2, minute);
        Log.d(TAG, "Add new alarm(" + hour + "," + minute + ")");
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }
}

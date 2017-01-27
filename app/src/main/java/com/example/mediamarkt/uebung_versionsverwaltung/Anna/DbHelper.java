package com.example.mediamarkt.uebung_versionsverwaltung.Anna;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mediamarkt on 27.01.2017.
 */

public class DbHelper extends SQLiteOpenHelper {
    private final static String DB_NAME="gpsData.db";
    private final static int DB_VERSION=1;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TblGpsData.SQL_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(TblGpsData.SQL_DROP);
        onCreate(sqLiteDatabase);
    }
}

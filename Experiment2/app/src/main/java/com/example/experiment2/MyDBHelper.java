package com.example.experiment2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper
{
    public static final String CREATE_TABLE = "CREATE TABLE user("
            + "username TEXT PRIMARY KEY, "
            + "password TEXT, "
            + "phone TEXT, "
            + "email TEXT, "
            + "sex TEXT)";

    private Context context;

    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
        this.context = context;
    }

        @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
    }
}

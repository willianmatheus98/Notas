package com.example.notas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String mDatabaseName = "banco.db";
    private static final int mVersion = 1;

    public DatabaseHelper(Context context) {
        super(context, mDatabaseName, null, mVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //cria a tabela
        db.execSQL(ScriptDLL.getCreateTableChecklist());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

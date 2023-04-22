package com.example.flagquiz

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseAssistant (context:Context) :
    SQLiteOpenHelper(context,"hobbit.db",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE IF NOT EXISTS  \"character\" (\n" +
                "\t\"character_id\"\tINTEGER,\n" +
                "\t\"character_name\"\tTEXT,\n" +
                "\t\"character_pic\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"character_id\")\n" +
                ");")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS character")
        onCreate(db)
    }


}
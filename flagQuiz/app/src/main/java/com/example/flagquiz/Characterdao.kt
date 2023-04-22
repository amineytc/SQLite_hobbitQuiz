package com.example.flagquiz

import android.annotation.SuppressLint

class Characterdao {

    @SuppressLint("Range")
    fun getRandomPicture(vt:DatabaseAssistant) : ArrayList<Character>{
        val pictureList = ArrayList<Character>()
        val db = vt.writableDatabase
        val c  = db.rawQuery("SELECT * FROM character ORDER BY RANDOM() LIMIT 10", null)
        while(c.moveToNext()){
            val picture = Character(c.getInt(c.getColumnIndex("character_id"))
                ,c.getString(c.getColumnIndex("character_name"))
                ,c.getString(c.getColumnIndex("character_pic")))
            pictureList.add(picture)
        }
        return pictureList
    }

    @SuppressLint("Range")
    fun get3WrongPictureRandom(vt:DatabaseAssistant, character_id : Int) : ArrayList<Character>{
        val pictureList = ArrayList<Character>()
        val db = vt.writableDatabase
        val c  = db.rawQuery("SELECT * FROM character WHERE character_id != $character_id ORDER BY RANDOM() LIMIT 10", null)
        while(c.moveToNext()){
            val picture = Character(c.getInt(c.getColumnIndex("character_id"))
                ,c.getString(c.getColumnIndex("character_name"))
                ,c.getString(c.getColumnIndex("character_pic")))
            pictureList.add(picture)
        }
        return pictureList
    }
}
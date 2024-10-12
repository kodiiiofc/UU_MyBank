package com.kodiiiofc.urbanuniversity.mybank

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.icu.text.Transliterator.Position
import android.util.Log
import android.widget.Toast

class DBHelper(val context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "users.db"
        private const val TABLE_NAME = "users"
        private const val KEY_USERNAME = "username"
        private const val KEY_PASSWORD = "content"
    }


    override fun onCreate(db: SQLiteDatabase?) {
        val TABLE =
            "CREATE TABLE $TABLE_NAME ($KEY_USERNAME TEXT PRIMARY KEY, $KEY_PASSWORD TEXT)"
        db?.execSQL(TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    @SuppressLint("Range")
    fun registerUser(username: String, password: String) : Boolean {
        val db = this.writableDatabase

        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME WHERE $KEY_USERNAME = '${username.trim().lowercase()}'", null)
        if (cursor.moveToFirst()) {
            return false
        }
        cursor.close()

        val contentValues = ContentValues()
        contentValues.put(KEY_USERNAME, username.lowercase().trim())
        contentValues.put(KEY_PASSWORD, password)
        db.insert(TABLE_NAME, null, contentValues)
        db.close()

        return true
    }

    @SuppressLint("Range")
    fun getPassword(username: String): String? {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME WHERE $KEY_USERNAME = '${username.trim().lowercase()}'", null)
        var password: String? = null
        if (cursor.moveToFirst()) {
                password = cursor.getString(cursor.getColumnIndex(KEY_PASSWORD))
        }
        cursor.close()
        db.close()
        return password
    }
}
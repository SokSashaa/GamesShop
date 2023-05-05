package com.example.lavanda;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME = "menu";
    public static final String TABLE_CONTACT="menu";
    public static String DATABASE_PATH = "";

    public static  final String KEY_ID="id";
    public static final String KEY_NAME="name";
    public static final String KEY_PRICE = "price";
    public static final String KEY_IMG = "image";
    public static final String KEY_CATEGORY ="id_category";
    Context myContext;


    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
        this.myContext=context;
        DATABASE_PATH =context.getFilesDir().getPath() + DATABASE_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    /*    db.execSQL("create table " + TABLE_CONTACT + " ("
                + KEY_ID + " integer primary key,"
                +KEY_INSTITUTE+ " text,"
                + KEY_SPEC + " text,"
                + KEY_GROUP + " text,"
                + KEY_TYPE_WEEK + " text,"
                + KEY_DAY_OF_WEEK + " text,"
                + KEY_NUMBER + " integer,"
                + KEY_SUBJECT + " text,"
                + KEY_PLACE + " text,"
                + KEY_TYPE_SUBJECT + " text,"
                + KEY_TEACHER + " text,"
                + KEY_COMMENT + " text"
                + ") ");*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {}
    void create_db(){

        File file = new File(DATABASE_PATH);
        if (!file.exists()) {
            //получаем локальную бд как поток
            try(InputStream myInput = myContext.getAssets().open(DATABASE_NAME);
                // Открываем пустую бд
                OutputStream myOutput = new FileOutputStream(DATABASE_PATH)) {

                // побайтово копируем данные
                byte[] buffer = new byte[1024];
                int length;
                while ((length = myInput.read(buffer)) > 0) {
                    myOutput.write(buffer, 0, length);
                }
                myOutput.flush();
            }
            catch(IOException ex){
                Log.d("DatabaseHelper", ex.getMessage());
            }
        }
    }
    public SQLiteDatabase open()throws SQLException {
        return SQLiteDatabase.openDatabase(DATABASE_PATH, null, SQLiteDatabase.OPEN_READWRITE);
    }
}

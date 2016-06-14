package com.example.shreyanshsachan.recyclerlist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Shreyansh Sachan on 14-Jun-16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ImageData";
    private static final String TABLE_NAME = "record";
    private static final int DATABASE_VERSION = 1;
    private static final String UID = "_uid";
    private static final String SOURCE = "source";
    private static final String PATH = "path";
    private static final String CREATE_TABLE = "create table "+TABLE_NAME+" ( "+UID+" integer primary key autoincrement, "+SOURCE+" varchar(255), "+PATH+" varchar(255) );";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.v("TAG", CREATE_TABLE);


        try{
            db.execSQL(CREATE_TABLE);
            Log.v("TAG","table created");
        }
        catch (Exception e){
            Log.v("TAG",""+e);
        }

        //SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();



        String sql1 = "insert into record (source,path) values ('camera', 'R.drawable.download1');";
        String sql2 = "insert into record (source,path) values ('camera', 'R.drawable.download1');";
        String sql3 = "insert into record (source,path) values ('galery', 'R.drawable.download1');";
        String sql4 = "insert into record (source,path) values ('galery', 'R.drawable.download1');";
        //Log.v("TAG", sql1);
        //sqLiteDatabase.execSQL(sql);

        try{
            Log.v("TAG", sql1);
            //sqLiteDatabase.execSQL(sql1);
            db.execSQL(sql1);
            Log.v("TAG","query inserted");

            Log.v("TAG", sql2);
            //sqLiteDatabase.execSQL(sql2);
            db.execSQL(sql2);
            Log.v("TAG","query inserted");

            Log.v("TAG", sql3);
            //sqLiteDatabase.execSQL(sql3);
            db.execSQL(sql3);
            Log.v("TAG","query inserted");

            Log.v("TAG", sql4);
            //sqLiteDatabase.execSQL(sql4);
            db.execSQL(sql4);
            Log.v("TAG","query inserted");
        }
        catch (Exception e){
            Log.v("TAG",""+e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

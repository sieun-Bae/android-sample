package com.example.summary6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class AppHelper {
    private static final String TAG = "AppHelper";
    private static SQLiteDatabase database;
    private static String createTableOutlineSql = "create table if not exists outline" +
            "(" +
            "_id integer PRIMARY KEY autoincrement, " +
            " id integer, " +
            " title text, " +
            " title_eng text, " +
            " dateValue text, " +
            " user_rating float, " +
            " audience_rating float, " +
            " reviewer_rating float, " +
            " reservation_rate float, " +
            " reservation_grade integer, " +
            " grade integer, " +
            " thumb text, " +
            " image text" +
            ")" ;

    public static void openDatabase(Context context,String databaseName) {

        //1. 데이터베이스 오픈
        println("openDatabase 호출됨.");

        try {
            database = context.openOrCreateDatabase(databaseName, Context.MODE_PRIVATE, null);
            if (database != null) {
                println("데이터베이스 " + databaseName + " 오픈됨.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createTable(String tableName) {
        println("createTable 호출됨: "+tableName);

        if (database != null) {
            if (tableName.equals("outline")) { //영화 목록
                database.execSQL(createTableOutlineSql);
                println("outline 테이블 생성 요청됨.");
            }
        } else {
            println("데이터베이스를 먼저 오픈하세요.");
        }

    }

    public static void println(String data) {
        Log.d(TAG, data);
    }
}

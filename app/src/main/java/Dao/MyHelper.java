//package Dao;
//
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import DefinSomeString.DefinSomeString;
//
///**
// * Created by Administrator on 2017/11/28.
// */
//
//public class MyHelper extends SQLiteOpenHelper {
//	public MyHelper(Context context){
//		super(context,"lyx_student_manager.db",null,2);
//	}
//	public void onCreate(SQLiteDatabase db){
//		System.out.println("onCreate");
//		//db.execSQL("CREATE TABLE account(_id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(20),balance INTEGER)");
//		db.execSQL("create table "
//				+ DefinSomeString.STUDENT_TABLE + "(_id Integer primary key AUTOINCREMENT,"
//				+ "name char,age integer, sex char, major char)");
//	}
//
//	@Override
//	public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
//		System.out.println("onUpgrade");
//	}
//}
//

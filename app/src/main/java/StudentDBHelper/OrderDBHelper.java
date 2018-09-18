package StudentDBHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import DefinSomeString.DefineOrderString;


/**
 * Created by Administrator on 2018/6/21.
 */

public class OrderDBHelper extends SQLiteOpenHelper{
	public static final String DB_NAME = "lyx_order_manager.db";
	public static final int VERSION = 2;

	public OrderDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	public OrderDBHelper(Context context) {
		this(context, DB_NAME, null, VERSION);
	}

	//创建
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table "
				+ DefineOrderString.ORDER_TABLE + "(_id Integer primary key AUTOINCREMENT,"
				+ "startplace char,endplace char, starttime char, endtime char)");
	}

	//更新
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}
}

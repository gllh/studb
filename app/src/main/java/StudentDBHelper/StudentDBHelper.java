package StudentDBHelper;

/**
 * Created by Administrator on 2017/11/26.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import DefinSomeString.DefinSomeString;

public class StudentDBHelper extends SQLiteOpenHelper {

	public static final String DB_NAME = "lyx_student_manager.db";
	public static final int VERSION = 2;

	public StudentDBHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	public StudentDBHelper(Context context) {
		this(context, DB_NAME, null, VERSION);
	}

	//创建
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table "
				+ DefinSomeString.STUDENT_TABLE + "(_id Integer primary key AUTOINCREMENT,"
				+ "name char,age integer, sex char, major char)");
	}

	//更新
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}
}

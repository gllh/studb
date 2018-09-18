package StudentOpt;

/**
 * Created by Administrator on 2017/12/2.
 */

import Student.Student;
import StudentDBHelper.StudentDBHelper;
import DefinSomeString.DefinSomeString;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.content.ContentValues;
import android.database.Cursor;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.studb.R;

public class StudentOpt {
	private StudentDBHelper dbHelper;
	private Cursor cursor;
	public StudentOpt(StudentDBHelper dbHelper) {
		this.dbHelper = dbHelper;
	}
	// 加一个Student对象数据到表
	public long addStudent(Student s) {
		ContentValues values = new ContentValues();
		values.put(DefinSomeString.Studentword.NAME, s.getName());
		values.put(DefinSomeString.Studentword.AGE, s.getAge());
		values.put(DefinSomeString.Studentword.SEX, s.getSex());
		values.put(DefinSomeString.Studentword.MAJOR, s.getMajor());
		return dbHelper.getWritableDatabase().insert(DefinSomeString.STUDENT_TABLE, null, values);
	}

	// 删by id
	public int deleteStudentById(long id) {
		return dbHelper.getWritableDatabase().delete(DefinSomeString.STUDENT_TABLE,
				DefinSomeString.Studentword.ID + "=?", new String[] { id + "" });
	}

	// 更新by id
	public int updateStudent(Student s) {
		ContentValues values = new ContentValues();
		values.put(DefinSomeString.Studentword.NAME, s.getName());
		values.put(DefinSomeString.Studentword.AGE, s.getAge());
		values.put(DefinSomeString.Studentword.SEX, s.getSex());
		values.put(DefinSomeString.Studentword.MAJOR, s.getMajor());
		return dbHelper.getWritableDatabase().update(DefinSomeString.STUDENT_TABLE, values,
				DefinSomeString.Studentword.ID + "=?", new String[] { s.getId() + "" });
	}
	// 查所有
	public List<Map<String,Object>> getAllStudents() {
		//modify_time desc
		List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		Cursor cursor = dbHelper.getWritableDatabase().query(DefinSomeString.STUDENT_TABLE, null,null, null,
				null, null, null+" desc");
		while(cursor.moveToNext()) {
			Map<String, Object> map = new HashMap<String, Object>(8);
			long id = cursor.getInt(cursor.getColumnIndex(DefinSomeString.Studentword.ID));
			map.put(DefinSomeString.Studentword.ID, id);
			String name = cursor.getString(cursor.getColumnIndex(DefinSomeString.Studentword.NAME));
			map.put(DefinSomeString.Studentword.NAME, name);
			int age = cursor.getInt(cursor.getColumnIndex(DefinSomeString.Studentword.AGE));
			map.put(DefinSomeString.Studentword.AGE, age);
			String sex = cursor.getString(cursor.getColumnIndex(DefinSomeString.Studentword.SEX));
			map.put(DefinSomeString.Studentword.SEX, sex);
			String major = cursor.getString(cursor.getColumnIndex(DefinSomeString.Studentword.MAJOR));
			map.put(DefinSomeString.Studentword.MAJOR, major);
			data.add(map);
		}
		return data;
	}
	//模糊查--无用
	public Cursor findStudent(String name){
		Cursor cursor = dbHelper.getWritableDatabase().query(DefinSomeString.STUDENT_TABLE,  null, "name like ？",
				new String[] { "%" + name + "%" }, null, null, null,null);
//		String sql="select from  name like '%"+name+"%' or major like "
//		dbHelper.getReadableDatabase().rawQuery(sql,null);
		return cursor;      }
	//全字段查--无用
	public Cursor findallinfoStudent(String info){
		Cursor cursor = dbHelper.getWritableDatabase().query(DefinSomeString.STUDENT_TABLE,  null, "name like ?",
				new String[] { "%" + info + "%" }, null, null, null,null);
		return cursor;      }
	//姓名排--无用
	public Cursor sortByName(){
		Cursor cursor = dbHelper.getWritableDatabase().query(DefinSomeString.STUDENT_TABLE,  null,null,
				null, null, null,DefinSomeString.Studentword.NAME);
		return cursor;     }
	//学号排--无用
	public Cursor sortByID(){
		Cursor cursor = dbHelper.getWritableDatabase().query(DefinSomeString.STUDENT_TABLE,  null,null,
				null, null, null,DefinSomeString.Studentword.ID);
		return cursor;    }
	public void closeDB() {
		dbHelper.close();     }
	//取一数据到
	public Student getStudentFromView(View view, long id) {
		TextView nameView = (TextView) view.findViewById(R.id.tv_stu_name);
		TextView ageView = (TextView) view.findViewById(R.id.tv_stu_age);
		TextView sexView = (TextView) view.findViewById(R.id.tv_stu_sex);
		TextView majorView = (TextView) view.findViewById(R.id.tv_stu_major);
		String name = nameView.getText().toString();
		int age = Integer.parseInt(ageView.getText().toString());
		String sex = sexView.getText().toString();
		String major = majorView.getText().toString();
		Student student = new Student(id, name, age, sex,major);
		return student;
	}
}


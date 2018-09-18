package StudentOpt;

import android.content.ContentValues;
import android.database.Cursor;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.studb.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DefinSomeString.DefineOrderString;
import Student.Order;
import StudentDBHelper.StudentDBHelper;
import StudentDBHelper.OrderDBHelper;

/**
 * Created by Administrator on 2018/6/21.
 */

public class OrderOpt {
	private OrderDBHelper dbHelper;
	private Cursor cursor;
	public OrderOpt(OrderDBHelper dbHelper) {
		this.dbHelper = dbHelper;
	}
	// 加一个Student对象数据到表
	public long addOrder(Order s) {
		ContentValues values = new ContentValues();
		values.put(DefineOrderString.Orderword.STARTPLACE, s.getStartplace());
		values.put(DefineOrderString.Orderword.ENDPLACE, s.getEndplace());
		values.put(DefineOrderString.Orderword.STARTTIME, s.getStarttime());
		values.put(DefineOrderString.Orderword.ENDTIME, s.getEndtime());
		return dbHelper.getWritableDatabase().insert(DefineOrderString.ORDER_TABLE, null, values);
	}

	// 删by id
	public int deleteOrderById(long id) {
		return dbHelper.getWritableDatabase().delete(DefineOrderString.ORDER_TABLE,
				DefineOrderString.Orderword.ID + "=?", new String[] { id + "" });
	}

	// 更新by id
	public int updateOrder(Order s) {
		ContentValues values = new ContentValues();
		values.put(DefineOrderString.Orderword.STARTPLACE, s.getStartplace());
		values.put(DefineOrderString.Orderword.ENDPLACE, s.getEndplace());
		values.put(DefineOrderString.Orderword.STARTTIME, s.getStarttime());
		values.put(DefineOrderString.Orderword.ENDTIME, s.getEndtime());
		return dbHelper.getWritableDatabase().update(DefineOrderString.ORDER_TABLE, values,
				DefineOrderString.Orderword.ID + "=?", new String[] { s.getId() + "" });
	}
	// 查所有
	public List<Map<String,Object>> getAllOrders() {
		//modify_time desc
		List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		Cursor cursor = dbHelper.getWritableDatabase().query(DefineOrderString.ORDER_TABLE, null,null, null,
				null, null, null+" desc");
		while(cursor.moveToNext()) {
			Map<String, Object> map = new HashMap<String, Object>(8);
			long id = cursor.getInt(cursor.getColumnIndex(DefineOrderString.Orderword.ID));
			map.put(DefineOrderString.Orderword.ID, id);
			String name = cursor.getString(cursor.getColumnIndex(DefineOrderString.Orderword.STARTPLACE));
			map.put(DefineOrderString.Orderword.STARTPLACE, name);
			String age = cursor.getString(cursor.getColumnIndex(DefineOrderString.Orderword.ENDPLACE));
			map.put(DefineOrderString.Orderword.ENDPLACE, age);
			String sex = cursor.getString(cursor.getColumnIndex(DefineOrderString.Orderword.STARTTIME));
			map.put(DefineOrderString.Orderword.STARTTIME, sex);
			String major = cursor.getString(cursor.getColumnIndex(DefineOrderString.Orderword.ENDTIME));
			map.put(DefineOrderString.Orderword.ENDTIME, major);
			data.add(map);
		}
		return data;
	}
	//模糊查--无用
	public Cursor findOrder(String name){
		Cursor cursor = dbHelper.getWritableDatabase().query(DefineOrderString.ORDER_TABLE,  null, "startplace like ？",
				new String[] { "%" + name + "%" }, null, null, null,null);
//		String sql="select from  name like '%"+name+"%' or major like "
//		dbHelper.getReadableDatabase().rawQuery(sql,null);
		return cursor;      }
	//全字段查--无用
	public Cursor findallinfoOrder(String info){
		Cursor cursor = dbHelper.getWritableDatabase().query(DefineOrderString.ORDER_TABLE,  null, "startplace like ?",
				new String[] { "%" + info + "%" }, null, null, null,null);
		return cursor;      }
	//姓名排--无用
	public Cursor sortByName(){
		Cursor cursor = dbHelper.getWritableDatabase().query(DefineOrderString.ORDER_TABLE,  null,null,
				null, null, null,DefineOrderString.Orderword.STARTPLACE);
		return cursor;     }
	//学号排--无用
	public Cursor sortByID(){
		Cursor cursor = dbHelper.getWritableDatabase().query(DefineOrderString.ORDER_TABLE,  null,null,
				null, null, null,DefineOrderString.Orderword.ID);
		return cursor;    }
	public void closeDB() {
		dbHelper.close();     }
	//取一数据到
	public Order getOrderFromView(View view, long id) {
		TextView nameView = (TextView) view.findViewById(R.id.tv_stu_name);
		TextView ageView = (TextView) view.findViewById(R.id.tv_stu_age);
		TextView sexView = (TextView) view.findViewById(R.id.tv_stu_sex);
		TextView majorView = (TextView) view.findViewById(R.id.tv_stu_major);
		String name = nameView.getText().toString();
		String age = nameView.getText().toString();
		String sex = sexView.getText().toString();
		String major = majorView.getText().toString();
		Order order = new Order(id, name, age, sex,major);
		return order;
	}
}
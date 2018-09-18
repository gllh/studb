package com.example.administrator.studb;

import android.os.Bundle;

import android.content.Intent;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.SimpleCursorAdapter;

//import StudentDBHelper.StudentDBHelper;
import StudentDBHelper.OrderDBHelper;
//import Student.Student;
import Student.Order;
//import StudentOpt.StudentOpt;
import StudentOpt.OrderOpt;
//import DefinSomeString.DefinSomeString;
import DefinSomeString.DefineOrderString;

public class MainActivity extends ListActivity implements OnClickListener,OnItemClickListener,OnItemLongClickListener{
	private static final String TAG = "TestSQLite";
	private ImageButton bt_useradd;
	private Button bt_option;
	//private ImageButton bt_option;
	private Button btadd;
	private Cursor cursor;
	private SimpleCursorAdapter adapter;
	private ListView listView;
	private List<Long> list;
//	private Student student;
private Order student;

//	private StudentOpt opt;
private OrderOpt opt2;

	private LinearLayout layout;

	private Boolean isDeleteList = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.e(TAG, "onCreate");
		list = new ArrayList<Long>();
//		student = new Student();
		student = new Order();
//		opt = new StudentOpt(new StudentDBHelper(this));
		opt2 = new OrderOpt(new OrderDBHelper(this));
		init();
	}
	private void init(){

		btadd=(Button)findViewById(R.id.btadd);
//		bt_useradd=(ImageButton)findViewById(R.id.bt_useradd);
		//bt_option=(ImageButton)findViewById(R.id.bt_option);
		bt_option=(Button)findViewById(R.id.bt_option);

	//	bt_useradd.setOnClickListener(this);
		btadd.setOnClickListener(this);
		bt_option.setOnClickListener(this);
		listView = getListView();

		listView.setOnItemClickListener(this);
		listView.setOnItemLongClickListener(this);
		listView.setOnCreateContextMenuListener(this);
	}
	@Override
	protected void onStart() {
		super.onStart();
		load();

	}
	// 长按Item菜单
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		MenuInflater inflater = new MenuInflater(this); //getMenuInflater();
		inflater.inflate(R.menu.menu2, menu);
	}
	// 长按Item进入的事件
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		int item_id = item.getItemId();
//		student = (Student) listView.getTag();
		student = (Order) listView.getTag();

		final long student_id = student.getId();
		Intent intent = new Intent();
		switch (item_id) {
			case R.id.delete:
				deleteStudentInformation(student_id);
				break;
			case R.id.rewrite:
				// 修改取现值到加界面后改finish返
//				intent.putExtra("studentdb", student);
				intent.putExtra("orderdb", student);
				intent.setClass(MainActivity.this, Main2Activity.class);
				this.startActivity(intent);
				break;
			default:
				break;
		}
		return super.onContextItemSelected(item);
	}
	// 单点Item---无
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
							long id) {

	}
	//长按Item先取
	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
	{
//		Student student = (Student) opt.getStudentFromView(view, id);
		Order student = (Order) opt2.getOrderFromView(view, id);
		listView.setTag(student);
		registerForContextMenu(listView);
		return false;
	}
	public  void onClick(View v) {
		Intent intent=new Intent();
		// 主界面按钮事件
		if (v == btadd) {
			startActivity(new Intent(MainActivity.this, Main2Activity.class));
		}
		if (v == bt_useradd) {
			startActivity(new Intent(MainActivity.this, Main2Activity.class));
		}
		if (v==bt_option){
			showPopupMenu(v);
		}
	}
	//点查询ImageButton出现pop菜单
	private void showPopupMenu(View view) {

		// View当前PopupMenu显示的相对View的位置
		PopupMenu popupMenu = new PopupMenu(this, view);
		// menu布局
		popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());
		// menu的item点击事件
		popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Intent i=new Intent();
				if (item.getItemId()==R.id.search)
				{
					i.setClass(MainActivity.this,Main3Activitysearch.class);
					startActivity(i);
				}
				return false;
			}
		});
		// PopupMenu关闭事件
		popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
			@Override
			public void onDismiss(PopupMenu menu) {
			}
		});

		popupMenu.show();
	}

	public void load() {
//		StudentDBHelper studentDBHelper = new StudentDBHelper(
//				MainActivity.this);
		OrderDBHelper studentDBHelper = new OrderDBHelper(
				MainActivity.this);
		SQLiteDatabase database = studentDBHelper.getWritableDatabase();
//		cursor = database.query(DefinSomeString.STUDENT_TABLE, null, null, null,
//				null, null, DefinSomeString.Studentword.ID + " asc");
		cursor = database.query(DefineOrderString.ORDER_TABLE, null, null, null,
				null, null, DefineOrderString.Orderword.ID + " asc");
		startManagingCursor(cursor);
//		adapter = new SimpleCursorAdapter(this, R.layout.student_list_item,
//				cursor, new String[] {DefinSomeString.Studentword.ID,
//				DefinSomeString.Studentword.NAME,
//				DefinSomeString.Studentword.AGE,
//				DefinSomeString.Studentword.SEX,
//				DefinSomeString.Studentword.MAJOR},
		adapter = new SimpleCursorAdapter(this, R.layout.student_list_item,
				cursor, new String[] {DefineOrderString.Orderword.ID,
				DefineOrderString.Orderword.STARTPLACE,
				DefineOrderString.Orderword.ENDPLACE,
				DefineOrderString.Orderword.STARTTIME,
				DefineOrderString.Orderword.ENDTIME},
				new int[] {
				R.id.tv_stu_id,
				R.id.tv_stu_name,
				R.id.tv_stu_age,
				R.id.tv_stu_sex,
				R.id.tv_stu_major});
		listView.setAdapter(adapter);
	}
	private void deleteStudentInformation(final long delete_id) {
		// 对话框删除AlterDialog
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("信息删除")
				.setMessage("确定删除所选记录?")
				.setCancelable(false)
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
//						int raws = opt.deleteStudentById(delete_id);
						int raws = opt2.deleteOrderById(delete_id);
						isDeleteList = !isDeleteList;
						load();
						if (raws > 0) {
							Toast.makeText(MainActivity.this, "删除成功!",
									Toast.LENGTH_LONG).show();
						} else
							Toast.makeText(MainActivity.this, "删除失败!",
									Toast.LENGTH_LONG).show();
					}
				})
				.setNegativeButton("取消", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				});
		AlertDialog alert = builder.create();
		alert.show();
	}


}

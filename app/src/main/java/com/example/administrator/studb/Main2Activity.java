package com.example.administrator.studb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.Serializable;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import StudentDBHelper.StudentDBHelper;
import StudentDBHelper.OrderDBHelper;
import Student.Student;
import Student.Order;
import StudentOpt.StudentOpt;
import StudentOpt.OrderOpt;
import DefinSomeString.DefinSomeString;
import DefinSomeString.DefineOrderString;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
	private RadioGroup group;
	private RadioButton button1;
	private RadioButton button2;


	private EditText nameText;
	private EditText ageText;

//
//
	private EditText spText;
	private EditText epText;
	private EditText stText;
	private EditText etText;
	//

	private String sex;
	private Spinner spin;

	private TextView idText;
	private TextView tvsss;

	private Button bt_adddb;

	private Long student_id;
	private StudentOpt opt;
	private OrderOpt opt2;
	private boolean isAdd = true;
	private String majorinfo;
	private static final String[] arr = { "交通","计算机","哲学","设计","文学","表演","医学","军事学","经济学","教育","历史"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
		init();
//		initspinner();
//		checkIsAddStudent();
		checkIsAddOrder();
	}
	private void  init(){
//		nameText = (EditText) findViewById(R.id.et_n);
//		ageText = (EditText) findViewById(R.id.et_a);

		spText = (EditText) findViewById(R.id.et_n);
		epText = (EditText) findViewById(R.id.et_a);
		stText = (EditText) findViewById(R.id.rg_sex);
		etText = (EditText) findViewById(R.id.tvzhuanye);

//		spin = (Spinner) findViewById(R.id.spin);
		bt_adddb = (Button) findViewById(R.id.bt_adddb);
		//id!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		idText = (TextView) findViewById(R.id.tv_stu_id);
		tvsss=(TextView) findViewById(R.id.tvsss);
//		button1 = (RadioButton) findViewById(R.id.nan);
//		button2 = (RadioButton) findViewById(R.id.rb_sex_female);
//		group = (RadioGroup) findViewById(R.id.rg_sex);
//		opt = new StudentOpt(new StudentDBHelper(this));
		opt2=new OrderOpt(new OrderDBHelper(this));
		bt_adddb.setOnClickListener(this);

	}
//	private  void initspinner()
//	{
//		//String[] arr = { "交通","计算机","哲学","设计","文学","表演"};
//		ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,arr);
//		spin.setAdapter(arrayAdapter);
//		spin.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
//			@Override
//			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//				majorinfo =spin.getSelectedItem().toString();
//			}
//			@Override
//			public void onNothingSelected(AdapterView<?> arg0) {
//				// TODO Auto-generated method studb
//			}
//		});
//	}
	// 检查此时Activity是否用于添加学员信息
//	private void checkIsAddStudent() {
//		Intent intent = getIntent();
//		Serializable serial = intent.getSerializableExtra(DefinSomeString.STUDENT_TABLE);
//		if (serial == null) {
//			isAdd = true;
//		} else {
//			isAdd = false;
//			Student s = (Student) serial;
//			showEditUI(s);
//		}
//	}
//	检查此时Activity是否用于添加Order信息
	private void checkIsAddOrder() {
		Intent intent = getIntent();
		Serializable serial = intent.getSerializableExtra(DefineOrderString.ORDER_TABLE);
		if (serial == null) {
			isAdd = true;
		} else {
			isAdd = false;
			Order s = (Order) serial;
			showEditUI(s);
		}
	}


	//显示信息更新
//	private void showEditUI(Student student) {
//		// 先将Student的数据还原到student的每一个中去
//		student_id = student.getId();
//		String name = student.getName();
//		int age = student.getAge();
//		String sex = student.getSex();
//		if (sex.toString().equals("male")) {
//			button2.setChecked(true);
//		} else if (sex.toString().equals("female")) {
//			button1.setChecked(true);
//		}
//		// 还原数据
//		idText.setText(student_id+"");
//		nameText.setText(name + "");
//		ageText.setText(age + "");
//	}
//显示Order信息更新
	private void showEditUI(Order student) {
		// 先将Student的数据还原到student的每一个中去
		student_id = student.getId();
		String name = student.getStartplace();
		String age = student.getEndplace();
		String sex = student.getStarttime();
		String major = student.getEndtime();
//		if (sex.toString().equals("male")) {
//			button2.setChecked(true);
//		} else if (sex.toString().equals("female")) {
//			button1.setChecked(true);
//		}
		// 还原数据
		idText.setText(student_id+"");
		spText.setText(name+"");
		epText.setText(age+"");
		stText.setText(sex+"");
		etText.setText(major+"");
	}
//	public void onClick(View v) {
//		// 加或改界面判断
//		if (v == bt_adddb) {
//			if (!checkUIInput()) {// 界面输入验证
//				return;
//			}
//			Student student = getStudentFromUI();
//			if (isAdd) {
//				long id = opt.addStudent(student);
//				opt.closeDB();
//				if (id > 0) {
//					Toast.makeText(this, "保存成功!!!， ID=" + id,Toast.LENGTH_SHORT).show();
//					finish();
//				} else {
//					Toast.makeText(this, "保存失败，请重新输入！", Toast.LENGTH_SHORT).show();
//				}
//			} else if (!isAdd) {
//				long id = opt.addStudent(student);
//				opt.closeDB();
//				if (id > 0) {
//					Toast.makeText(this, "更新成功!!!!!",Toast.LENGTH_SHORT).show();
//					finish();
//				} else {
//					Toast.makeText(this, "更新失败，请重新输入！",Toast.LENGTH_SHORT).show();
//				}
//			}
//		}
//	}
public void onClick(View v) {
	// 加或改界面判断
	if (v == bt_adddb) {
		if (!checkUIInput()) {// 界面输入验证
			return;
		}
		Order student = getOrderFromUI();
		if (isAdd) {
			long id = opt2.addOrder(student);
			opt.closeDB();
			if (id > 0) {
				Toast.makeText(this, "保存成功!!!， ID=" + id,Toast.LENGTH_SHORT).show();
				finish();
			} else {
				Toast.makeText(this, "保存失败，请重新输入！", Toast.LENGTH_SHORT).show();
			}
		} else if (!isAdd) {
			long id = opt2.addOrder(student);
			opt.closeDB();
			if (id > 0) {
				Toast.makeText(this, "更新成功!!!!!",Toast.LENGTH_SHORT).show();
				finish();
			} else {
				Toast.makeText(this, "更新失败，请重新输入！",Toast.LENGTH_SHORT).show();
			}
		}
	}
}

	//是否正确输入
//	private boolean checkUIInput() { // name, age, sex
//		String name = nameText.getText().toString();
//		String age = ageText.getText().toString();
//		int id = group.getCheckedRadioButtonId();
//		String message = null;
//		View invadView = null;
//		if (name.trim().length() == 0) {
//			message = "请输入姓名!";
//			invadView = nameText;
//		} else if (age.trim().length() == 0) {
//			message = "请输入年龄!";
//			invadView = ageText;
//		} else if (id == -1) {
//			message = "请选择性别!";
//		}
//		if (message != null) {
//			Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
//			if (invadView != null)
//				invadView.requestFocus();
//			return false;
//		}         return true;     }
	//是否正确输入Order
	private boolean checkUIInput() { // name, age, sex
		String name = spText.getText().toString();
		String age = epText.getText().toString();
		String sex = stText.getText().toString();
		String major = etText.getText().toString();
//		int id = group.getCheckedRadioButtonId();
		String message = null;
		View invadView = null;
		if (name.trim().length() == 0) {
			message = "请输入始发地!";
			invadView = spText;
		} else if (age.trim().length() == 0) {
			message = "请输入终止地!";
			invadView = epText;
		} else if (sex.trim().length() == 0) {
			message = "请输入始发时!";
			invadView = stText;
		}else if (major.trim().length() == 0) {
			message = "请输入终止时!";
			invadView = etText;
		}
		if (message != null) {
			Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
			if (invadView != null)
				invadView.requestFocus();
			return false;
		}         return true;
	}
	//    封装成Student
//	private Student getStudentFromUI() {
//		String name = nameText.getText().toString();
//		int age = Integer.parseInt(ageText.getText().toString());
//		String sex = ((RadioButton) findViewById(group
//				.getCheckedRadioButtonId())).getText().toString();
//		Student s=new Student(name, age, sex,majorinfo);
//		if (!isAdd) {
//			s.setId(Integer.parseInt(idText.getText().toString()));
//			opt.deleteStudentById(student_id);
//		}
//		return s;
//	}
	//    封装成Order
	private Order getOrderFromUI() {
		String name = spText.getText().toString();
		String age = spText.getText().toString();
		String sex = stText.getText().toString();
		String majorinfo = etText.getText().toString();
		Order s=new Order(name, age, sex,majorinfo);
		if (!isAdd) {
			s.setId(Integer.parseInt(idText.getText().toString()));
			opt2.deleteOrderById(student_id);
		}
		return s;
	}



}

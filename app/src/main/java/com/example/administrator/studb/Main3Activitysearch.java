package com.example.administrator.studb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import StudentDBHelper.StudentDBHelper;
import StudentDBHelper.OrderDBHelper;
//import DefinSomeString.DefinSomeString;
import DefinSomeString.DefineOrderString;

import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
//import StudentOpt.StudentOpt;
import StudentOpt.OrderOpt;

public class Main3Activitysearch extends AppCompatActivity implements View.OnClickListener{
	private EditText nameText;
	private Button button;
	private Button reButton;
	private Cursor cursor;
	private SimpleCursorAdapter adapter;
	private ListView listView;
//	private StudentOpt opt;
private OrderOpt opt2;
	private Button returnButton;
	private LinearLayout layout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main3_activitysearch);
		init();
	}
	private void init(){
		nameText = (EditText) findViewById(R.id.et_srarch);
		layout=(LinearLayout) findViewById(R.id.linersearch);
		button = (Button) findViewById(R.id.bn_sure_search);
		reButton = (Button) findViewById(R.id.bn_return);
		listView = (ListView) findViewById(R.id.searchListView);
		returnButton = (Button) findViewById(R.id.return_id);
//		opt = new StudentOpt(new StudentDBHelper(this));
		opt2 = new OrderOpt(new OrderDBHelper(this));


		reButton.setOnClickListener(this);
		returnButton.setOnClickListener(this);
		button.setOnClickListener(this);
}
	@Override
	public void onClick(View v) {
		if (v == button) {
			reButton.setVisibility(View.GONE);
			button.setVisibility(View.GONE);
			nameText.setVisibility(View.GONE);
			layout.setVisibility(View.VISIBLE);
			String name = nameText.getText().toString();
//			cursor = opt.findallinfoStudent(name);
			cursor = opt2.findallinfoOrder(name);
			if (!cursor.moveToFirst()) {
//				Toast.makeText(this, "没有所查学员信息！", Toast.LENGTH_SHORT).show();
				Toast.makeText(this, "没有所查物流信息！", Toast.LENGTH_SHORT).show();
			} else
				//如果查，则显
				adapter = new SimpleCursorAdapter(this, R.layout.searchresult,
						cursor,
						new String[] {DefineOrderString.Orderword.ID,


								DefineOrderString.Orderword.STARTPLACE,
								DefineOrderString.Orderword.ENDPLACE,
								DefineOrderString.Orderword.STARTTIME,
								DefineOrderString.Orderword.ENDTIME
						}, new int[] {R.id.tv_stu_id, R.id.tv_stu_name, R.id.tv_stu_age, R.id.tv_stu_sex, R.id.tv_stu_major});
			listView.setAdapter(adapter);
		}else if(v==reButton|v==returnButton){
			finish();
		}
	}
}

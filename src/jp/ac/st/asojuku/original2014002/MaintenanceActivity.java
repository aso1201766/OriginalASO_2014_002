package jp.ac.st.asojuku.original2014002;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MaintenanceActivity extends Activity implements View.OnClickListener,
		AdapterView.OnItemClickListener{

	public void setDBValuetoList(ListView listView1){
		
		SQLiteCursor cursor = null;
		
		if(sdb==null){
			helper = new MySQLiteOpenHelper(getApplicationContext());
		}
		try{
			sdb = helper.getWritableDatabase();
		}catch(SQLiteException e){
			Log.e("ERROR",e.toString());
		}
		cursor = this.helper.selectHitokotoList(sdb);
		
		int db_layout = android.R.layout.simple_list_item_activated_1;
		
		String[]from = {"phrase"};
		
		int[] to = new int[]{android.R.id.text1};
		
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,db_layout,cursor,from,to,0);
		
		listView1.setAdapter(adapter);
	}
	
	SQLiteDatabase sdb = null;
	MySQLiteOpenHelper helper = null;
	
	int selectdID = -1;
	int lastPosition = -1;
	
	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		Button btnBack = (Button)findViewById(R.id.btnback);
		Button btnD = (Button)findViewById(R.id.btnD);
		ListView listView1 = (ListView)findViewById(R.id.listView1);
		
		btnBack.setOnClickListener(this);
		btnD.setOnClickListener(this);
		
		listView1.setOnItemClickListener(this);
		
		this.setDBVaiuetoList(listView1);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.maintenanceactivity);
	}

	@Override
	public void onClick(View v) {
	// TODO 自動生成されたメソッド・スタブ
	Intent intent = null;
	switch(v.getId()){

	case R.id.btnback:
		Intent intent = new Intent(MaintenanceActivity.this,MaintenanceActivity.class);
		
		stratActivity(intent);
	
	}
	
}
}

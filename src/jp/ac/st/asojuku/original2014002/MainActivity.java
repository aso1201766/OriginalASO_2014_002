package jp.ac.st.asojuku.original2014002;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity implements View.OnClickListener
{
	SQLiteDatabase sdb = null;
	MySQLiteOpenHelper helper = null;


	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		Intent intent = null;
		switch(v.getId()){

		case R.id.btnD:
			EditText etv = (EditText)findViewById(R.id.t_text);
			String inputMsg = etv.getText().toString();

			if(inputMsg!=null && !inputMsg.isEmpty()){
				helper.insertHitokoto(sdb,inputMsg);
			}
			etv.setText("");
			break;
		case R.id.btnback:
			intent = new Intent(MainActivity.this,MaintenanceActivity.class);
			startActivity(intent);
			break;
		case R.id.btnc:
			String strHitokoto = helper.selectRandomHitokoto(sdb);
			intent = new Intent(MainActivity.this,HitokotoActivity.class);
			intent.putExtra("hitokoto", strHitokoto);
			startActivity(intent);
			break;
		}
	}


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		
		//登録ボタン変数にリスナーを登録する
		Button btnt = (Button)findViewById(R.id.btnD);
		btnt.setOnClickListener(this);
		
		//メンテボタン変数にリスナーを登録する
		Button btnmnt = (Button)findViewById(R.id.btnback);
		btnmnt.setOnClickListener(this); 
		
		//一言チェックボタン変数にリスナーを登録する
		Button btnc = (Button)findViewById(R.id.btnc);
		btnc.setOnClickListener(this);
		
		//クラスのフィールド変数がnullならデータベース空間オープン
		if(sdb == null){
			helper = new MySQLiteOpenHelper(getApplicationContext());
		}
		try{
			sdb = helper.getWritableDatabase();
		}catch(SQLiteException e){
			//異常終了
			return;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
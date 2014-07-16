package jp.ac.st.asojuku.original2014002;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MaintenanceActivity extends Activity {

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
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
		finish();
		
		break;
	
	}
}
}

package mingle.unimelb.lunchamigo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.content.Intent;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void goToLogin(View view) {
	    // Do something in response to button
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
	}
	
	public void goToOption(View view) {
		Intent intent = new Intent(this, OptionGateway.class);// Do something in response to button
		startActivity(intent);
	}
	
	

}

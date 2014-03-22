package mingle.unimelb.lunchamigo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class OptionGateway extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_option_gateway);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.option_gateway, menu);
		return true;
	}

}

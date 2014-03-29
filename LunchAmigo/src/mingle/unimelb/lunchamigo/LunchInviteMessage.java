package mingle.unimelb.lunchamigo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;


public class LunchInviteMessage extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lunch_invite_message);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lunch_invite_message, menu);
		return true;
	}

}

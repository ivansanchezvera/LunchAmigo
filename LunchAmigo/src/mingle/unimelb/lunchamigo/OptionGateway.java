package mingle.unimelb.lunchamigo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

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
	
	public void goToInputTime(View view) {
		Intent intent = new Intent(this, InputTime.class);// Do something in response to button
		startActivity(intent);
	}

	public void goToFindLunchAmigo(View view) {
		Intent intent = new Intent(this, InputTime.class);// Should go to FindLunchAmigo
		startActivity(intent);
	}
	
	public void goToFindFriends(View view) {
		Intent intent = new Intent(this, InputTime.class);// Should go to find Friends
		startActivity(intent);
	}
	
	public void goToLunchInviteMessage(View view) {
		Intent intent = new Intent(this, LunchInviteMessage.class);// Should go to send invite message
		startActivity(intent);
	}
	
}

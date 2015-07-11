package wizard.threeperson.activity;

import wizard.threeperson.client.R;
import wizard.threeperson.client.R.layout;
import wizard.threeperson.client.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class WelcomeActivity extends Activity {

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

}

package wizard.threeperson.activity;

import wizard.threeperson.adapter.GuestAllTradeAdapter;
import wizard.threeperson.client.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class GuestAllTradeActivity extends Activity {
	private ListView lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guest_alltrade_layout);
		lv = (ListView) findViewById(R.id.lv);
		GuestAllTradeAdapter adapter = new GuestAllTradeAdapter(this);
		lv.setAdapter(adapter);
	}
}

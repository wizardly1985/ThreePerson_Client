package wizard.threeperson.activity;

import wizard.threeperson.adapter.GusetCurrentOrderAdapter;
import wizard.threeperson.client.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class GuestCurrentOrderActivity extends Activity {
	private ListView lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guest_currentorder_layout);
		lv = (ListView) findViewById(R.id.lv);
		GusetCurrentOrderAdapter adapter = new GusetCurrentOrderAdapter(this);
		lv.setAdapter(adapter);
	}
}

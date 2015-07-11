package wizard.threeperson.activity;

import wizard.threeperson.adapter.DelivererAllTradeAdapter;
import wizard.threeperson.client.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class DelivererAllTradeActivity extends Activity {
	private ListView lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.deliverer_alltrade_layout);
		lv = (ListView) findViewById(R.id.lv);
		DelivererAllTradeAdapter adapter = new DelivererAllTradeAdapter(this);
		lv.setAdapter(adapter);
	}
}

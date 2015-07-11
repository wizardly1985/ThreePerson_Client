package wizard.threeperson.activity;

import wizard.threeperson.adapter.DelivererCurrentOrderAdapter;
import wizard.threeperson.client.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class DelivererCurrentOrderActivity extends Activity {
	private ListView lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.deliverer_currentorder_layout);
		lv = (ListView) findViewById(R.id.lv);
		DelivererCurrentOrderAdapter adapter = new DelivererCurrentOrderAdapter(this);
		lv.setAdapter(adapter);
		
	}
}

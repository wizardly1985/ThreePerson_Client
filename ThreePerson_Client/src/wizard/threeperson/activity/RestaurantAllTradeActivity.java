package wizard.threeperson.activity;

import wizard.threeperson.adapter.RestaurantAllTradeAdapter;
import wizard.threeperson.client.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class RestaurantAllTradeActivity extends Activity {
	private ListView lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.restaurant_alltrade_layout);
		lv=(ListView) findViewById(R.id.lv);
		RestaurantAllTradeAdapter adapter = new RestaurantAllTradeAdapter(this);
		lv.setAdapter(adapter);
		
	}
}

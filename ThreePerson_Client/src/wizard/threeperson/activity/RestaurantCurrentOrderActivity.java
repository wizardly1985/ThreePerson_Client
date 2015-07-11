package wizard.threeperson.activity;

import wizard.threeperson.adapter.RestaurantCurrentOrderAdapter;
import wizard.threeperson.client.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class RestaurantCurrentOrderActivity extends Activity {
	ListView listView;
@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.restaurant_currentorder_layout);
	listView =(ListView) findViewById(R.id.listView);
	RestaurantCurrentOrderAdapter adapter = new RestaurantCurrentOrderAdapter(this);
	listView.setAdapter(adapter);
	
}
}

package wizard.threeperson.activity;

import wizard.threeperson.adapter.RestaurantAllFoodAdapter;
import wizard.threeperson.client.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

/**
 * @author y 该店发布的所有的菜
 * 
 */
public class RestaurantAllFoodActivity extends Activity {
	private ListView lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.restaurant_allfood_layout);
		lv=(ListView) findViewById(R.id.lv);
		RestaurantAllFoodAdapter adapter = new RestaurantAllFoodAdapter(this);
		lv.setAdapter(adapter);
	}
}

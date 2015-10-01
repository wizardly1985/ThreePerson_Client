package wizard.threeperson.activity;

import wizard.threeperson.adapter.RestaurantAllFoodAdapter;
import wizard.threeperson.client.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

/**
 * @author y �õ귢�������еĲ�
 * 
 */
public class RestaurantAllFoodActivity extends Activity {
	private ListView lv;
	
	public static void launch(Context c) {
		Intent intent = new Intent(c, RestaurantAllFoodActivity.class);
		c.startActivity(intent);

	}

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

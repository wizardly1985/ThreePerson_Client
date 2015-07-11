package wizard.threeperson.activity;

import wizard.threeperson.App;
import wizard.threeperson.client.R;
import wizard.threeperson.entity.GuestUser;
import wizard.threeperson.entity.RestaurantUser;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RestaurantHomePageActivity extends Activity {
	ImageView ivBackground;
	ImageView ivHead;
	TextView tvUsername;
	TextView tvPhone;
	TextView tvAddress;
	
	private RestaurantUser user = (RestaurantUser) App.getInstance().getUser();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.restaurant_homepage_layout);
		findViewById();
	}

	private void findViewById() {
		ivBackground = (ImageView) findViewById(R.id.ivBackground);
		ivHead = (ImageView) findViewById(R.id.ivhead);
		tvUsername = (TextView) findViewById(R.id.tvUsername);
		tvPhone = (TextView) findViewById(R.id.tvPhone);
		tvAddress = (TextView) findViewById(R.id.tvAddress);
		
		tvUsername.setText(user.getUsername());
		tvPhone.setText(user.getPhone());
		tvAddress.setText(user.getAddress());
		
	}
}

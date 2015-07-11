package wizard.threeperson.activity;

import wizard.threeperson.App;
import wizard.threeperson.client.R;
import wizard.threeperson.entity.DelivererUser;
import wizard.threeperson.entity.GuestUser;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GuestHomePageActivity extends Activity {
	
	ImageView ivBackground;
	ImageView ivHead;
	TextView tvUsername;
	TextView tvPhone;
	TextView tvAddress;
	
	private GuestUser user = (GuestUser) App.getInstance().getUser();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guest_homepage_layout);
		findViewById();
	}
	private void findViewById() {
		ivBackground = (ImageView) findViewById(R.id.ivBackground);
		ivHead = (ImageView) findViewById(R.id.ivhead);
		tvUsername=(TextView) findViewById(R.id.tvName);
		tvPhone=(TextView) findViewById(R.id.tvPhone);
		tvAddress=(TextView) findViewById(R.id.tvAddress);
		
		tvUsername.setText(user.getUsername());
		tvPhone.setText(user.getPhone());
		tvAddress.setText(user.getAddress());
		
		
	}
}

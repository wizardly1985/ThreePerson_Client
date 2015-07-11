package wizard.threeperson.activity;

import wizard.threeperson.App;
import wizard.threeperson.client.R;
import wizard.threeperson.entity.DelivererUser;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DelivererHomePageActivity extends Activity {
	
	ImageView ivBackground;
	ImageView ivHead;
	TextView tvUsername;
	TextView tvPhone;
	TextView tvAddress;
	
	private DelivererUser user = (DelivererUser) App.getInstance().getUser();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.deliverer_homepage_layout);
		findViewById();
	
	}
	private void findViewById() {
		ivBackground = (ImageView) findViewById(R.id.ivBackground);
		ivHead =(ImageView) findViewById(R.id.ivhead);
		tvUsername = (TextView) findViewById(R.id.tvUsername);
		tvAddress = (TextView) findViewById(R.id.tvAddress);
		tvPhone = (TextView) findViewById(R.id.tvPhone);
		
		tvUsername.setText(user.getUsername());
		tvAddress.setText(user.getAddress());
		tvPhone.setText(user.getPhone());
	}
}

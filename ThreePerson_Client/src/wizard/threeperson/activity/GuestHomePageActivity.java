package wizard.threeperson.activity;

import wizard.threeperson.App;
import wizard.threeperson.client.R;
import wizard.threeperson.entity.GuestUser;
import wizard.threeperson.views.RemoteImageView;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class GuestHomePageActivity extends Activity {

	TextView tvUsername;
	TextView tvPhone;
	TextView tvAddress;
	RelativeLayout btnPrivate;
	RelativeLayout btnInfo;
	RelativeLayout btnFood;
	RelativeLayout btnOrder;
	RelativeLayout btnTrade;
	RelativeLayout btnNewFood;
	RelativeLayout btnCheckMenu;
	RemoteImageView backIv;
	RemoteImageView headIv;

	private GuestUser user;

	public static void launch(Context c) {
		Intent intent = new Intent(c, GuestHomePageActivity.class);
		c.startActivity(intent);

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setTitle("ÓÃ»§Ö÷Ò³");
		setContentView(R.layout.guest_homepage_layout);
		user = App.getInstance().getUser();
		System.out.println("----->>" + user.getPassword());
		findViewById();
	}

	private void findViewById() {
		tvUsername = (TextView) findViewById(R.id.tvUsername);
		tvPhone = (TextView) findViewById(R.id.tvPhone);
		tvAddress = (TextView) findViewById(R.id.tvAddress);

		System.out.println(user.getUsername());

		tvUsername.setText(user.getUsername());
		tvPhone.setText(user.getPhone());
		tvAddress.setText(user.getAddress());

		backIv = (RemoteImageView) findViewById(R.id.ivBackground);
		headIv = (RemoteImageView) findViewById(R.id.ivHead);

		btnPrivate = (RelativeLayout) findViewById(R.id.btnPrivate);
		btnPrivate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				GuestRegisterActivity.launch(GuestHomePageActivity.this);
			}
		});

		btnFood = (RelativeLayout) findViewById(R.id.btnFood);
		btnFood.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				GusetChooseFoodActivity.launch(GuestHomePageActivity.this);
			}
		});

		btnOrder = (RelativeLayout) findViewById(R.id.btnOrder);
		btnOrder.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				GuestCurrentOrderActivity.launch(GuestHomePageActivity.this);
			}
		});

		btnTrade = (RelativeLayout) findViewById(R.id.btnTrader);
		btnTrade.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				GuestAllTradeActivity.launch(GuestHomePageActivity.this);
			}
		});
		
		btnNewFood= (RelativeLayout) findViewById(R.id.newFood);
		btnNewFood.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				RestaurantNewFoodActivity.launch(GuestHomePageActivity.this);
			}
		});
		
		btnCheckMenu= (RelativeLayout) findViewById(R.id.checkMenu);
		btnCheckMenu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				RestaurantAllFoodActivity.launch(GuestHomePageActivity.this);
			}
		});

		backIv.loadImage("http://10.0.2.2:8080/ThreePerson_Server/images/E-F-004.jpg");
		headIv.loadImage("http://10.0.2.2:8080/ThreePerson_Server/images/95588.jpg");
	}

}

package wizard.threeperson.activity;

import wizard.threeperson.App;
import wizard.threeperson.client.R;
import wizard.threeperson.entity.GuestUser;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class GuestInfoActivity extends Activity {
	
	GuestUser user;
	private TextView tvName;
	private TextView tvAccount;
	private TextView tvPhone;
	private TextView tvTrade;
	private TextView tvActive;
	private TextView tvType;
	private TextView tvAddress;
	private TextView tvPriority;
	private TextView tvTurnover;

	public static void launch(Context context){
		Intent i= new Intent(context, GuestInfoActivity.class);
		context.startActivity(i);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("œÍœ∏–≈œ¢");
		setContentView(R.layout.guest_info_layout);
		user = App.getInstance().getUser();
		findViewById();
	}

	private void findViewById() {
		tvName = (TextView) findViewById(R.id.tvName);
		tvAccount = (TextView) findViewById(R.id.tvAccount);
		tvPhone = (TextView) findViewById(R.id.tvPhone);
		tvTrade = (TextView) findViewById(R.id.tvTrade);
		tvActive = (TextView) findViewById(R.id.tvActive);
		tvType = (TextView) findViewById(R.id.tvType);
		tvAddress = (TextView) findViewById(R.id.tvAddress);
		tvPriority = (TextView) findViewById(R.id.tvPriority);
		tvTurnover = (TextView) findViewById(R.id.tvTurnover);
		
		tvName.setText(tvName.getText().toString()+":"+user.getUsername());
		tvAccount.setText(tvAccount.getText().toString()+":"+user.getAccount());
		tvPhone.setText(tvPhone.getText().toString()+":"+user.getPhone());
		tvTrade.setText(tvTrade.getText().toString()+":"+user.getTrade());
		tvActive.setText(tvActive.getText().toString()+":"+user.getActivty());
		tvType.setText(tvType.getText().toString()+":"+user.getType());
		tvAddress.setText(tvAddress.getText().toString()+":"+user.getAddress());
		tvPriority.setText(tvPriority.getText().toString()+":"+user.getPriority());
		tvTurnover.setText(tvTurnover.getText().toString()+":"+user.getTurnover());
		
	}
}

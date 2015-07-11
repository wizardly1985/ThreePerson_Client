package wizard.threeperson.activity;

import wizard.threeperson.App;
import wizard.threeperson.api.ApiImpl;
import wizard.threeperson.client.R;
import wizard.threeperson.dao.impl.UserDaoImpl;
import wizard.threeperson.entity.AbsUser;
import wizard.threeperson.entity.DelivererUser;
import wizard.threeperson.entity.GuestUser;
import wizard.threeperson.entity.RestaurantUser;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class LoginActivity extends Activity {
	RadioGroup radioGroup = null;
	TextView etUsername = null;
	TextView etPassword = null;
	Button btnRegister = null;
	Button btnLogin = null;
	
	AbsUser user = new RestaurantUser(null, null);
	ApiImpl api = (ApiImpl) App.getInstance().getApi();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_layout);
		findViewById();
	}

	private void findViewById() {
		radioGroup =(RadioGroup) findViewById(R.id.radioGroupRole);
		etUsername =(TextView) findViewById(R.id.etUsername);
		etPassword = (TextView) findViewById(R.id.etPassword);
		btnRegister = (Button) findViewById(R.id.btnRegister);
		btnLogin = (Button) findViewById(R.id.btnLogin);
		btnLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				login();
			}
		});
		btnRegister.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				register();
			}
		});
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				System.out.println("送餐系统————>>用户选择:"+arg1);
				
				switch (arg1) {
				
				case R.id.radio1:
					LoginActivity.this.user =new GuestUser(null, null);
					break;
					
				case R.id.radio0:
					break;
					
				case R.id.radio2:
					LoginActivity.this.user =new DelivererUser(null, null);
					break;

				default:
					break;
				}
			}
		});
	}

	protected void register() {
		System.out.println("送餐系统————>>注册");		
		
	}

	protected void login() {
		System.out.println("送餐系统————>>登陆");
		user.setUsername(etUsername.getText().toString());
		user.setPassword(etPassword.getText().toString());
		api.login(user);
	}
}

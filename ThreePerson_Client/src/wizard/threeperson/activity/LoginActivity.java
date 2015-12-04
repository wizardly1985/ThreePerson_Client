package wizard.threeperson.activity;

import wizard.threeperson.App;
import wizard.threeperson.api.ApiImpl;
import wizard.threeperson.client.R;
import wizard.threeperson.entity.GuestUser;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {
	RadioGroup radioGroup = null;
	TextView etUsername = null;
	TextView etPassword = null;
	Button btnRegister = null;
	Button btnLogin = null;
	
	GuestUser user = App.getInstance().getUser();
	ApiImpl api = (ApiImpl) App.getInstance().getApi();

	public static void launch(Context context){
		Intent i= new Intent(context, LoginActivity.class);
		context.startActivity(i);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setTitle("µÇÂ½");
		setContentView(R.layout.login_layout);
		findViewById();
	}

	private void findViewById() {
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
	}

	protected void register() {
		System.out.println("ËÍ²ÍÏµÍ³¡ª¡ª¡ª¡ª>>×¢²á");		
		Intent intent = new Intent(this, GuestRegisterActivity.class);
		startActivity(intent);
		
	}

	protected void login() {
		System.out.println("ËÍ²ÍÏµÍ³¡ª¡ª¡ª¡ª>>µÇÂ½");
		user.setUsername(etUsername.getText().toString());
		user.setPassword(etPassword.getText().toString());
		user.setRole("guest");
		System.out.println(user.getPassword());
		new LoginTask().execute(user);
		//api.login(user);
	}
	
	class LoginTask extends AsyncTask<GuestUser, Void, GuestUser>{

		@Override
		protected GuestUser doInBackground(GuestUser... user) {
			return (GuestUser) api.login(user[0]);
		}
		@Override
		protected void onPostExecute(GuestUser user) {
			super.onPostExecute(user);
			Toast.makeText(LoginActivity.this, "µÇÂ½", 3000).show();
			System.out.println("address--->>"+user.getAddress());
			App.getInstance().setUser(user);
			App.getInstance().setShareXML(LoginActivity.this);
			GuestHomePageActivity.launch(LoginActivity.this);
			finish();
		}
	}
}

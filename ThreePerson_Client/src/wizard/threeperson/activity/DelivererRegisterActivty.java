package wizard.threeperson.activity;

import java.util.Date;

import wizard.threeperson.App;
import wizard.threeperson.api.ApiImpl;
import wizard.threeperson.client.R;
import wizard.threeperson.entity.AbsUser;
import wizard.threeperson.entity.DelivererUser;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class DelivererRegisterActivty extends Activity {

	private EditText etName;
	private EditText etPassword;
	private EditText etConfrimPassword;
	private EditText etSourceAddress;
	private EditText etDestinationAddress;
	private EditText etPhone;
	private EditText etAccount;
	private Button submitBtn;

	/**
	 * 用户的引用
	 */
	DelivererUser user;
	
	ApiImpl api=(ApiImpl) App.getInstance().getApi();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.deliverer_register_layout);
		findViewById();
	}

	/**
	 * 填充USER的所有项
	 */
	private void fillUser() {
		if (checkPassword() == false)
			return;
		user = new DelivererUser(etName.getText().toString(), etPassword
				.getText().toString());
		user.setDestination_scale(etDestinationAddress.getText().toString());
		user.setSource_scale(etSourceAddress.getText().toString());
		user.setPhone(etPhone.getText().toString());
		user.setAccount(etAccount.getText().toString());
		
		//填充其他由系统自动产生的信息
		user.setActivty(0);
		user.setRegiterDate(new Date(1985, 5, 22, 12, 12, 12));
		user.setGps("经纬度");
		user.setTrade(0);
		user.setTurnover(0);
		
	}

	/**
	 * 检查密码是否一致
	 * @return
	 */
	private boolean checkPassword() {
		if (etPassword.getText().toString()
				.equals(etConfrimPassword.getText().toString()) == true)
			return true;
		return false;
	}

	private void findViewById() {
		etName = (EditText) findViewById(R.id.etName);
		etPassword = (EditText) findViewById(R.id.etPassword);
		etConfrimPassword = (EditText) findViewById(R.id.etConfirmPW);
		etSourceAddress = (EditText) findViewById(R.id.etSourceAddress);
		etDestinationAddress = (EditText) findViewById(R.id.etDestinationAddress);
		etPhone = (EditText) findViewById(R.id.etPhone);
		etAccount = (EditText) findViewById(R.id.etAccount);
		submitBtn = (Button) findViewById(R.id.btnSubmit);
		submitBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				fillUser();
				if(api.register(user)==true){
					System.out.println("注册成功，界面跳转");
				}else{
					System.out.println("注册失败，提示信息！！");
				}
			}
		});
	}

}

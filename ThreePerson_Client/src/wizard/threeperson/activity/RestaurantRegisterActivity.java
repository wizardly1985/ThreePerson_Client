package wizard.threeperson.activity;

import java.util.Date;

import wizard.threeperson.App;
import wizard.threeperson.api.ApiImpl;
import wizard.threeperson.client.R;
import wizard.threeperson.client.R.id;
import wizard.threeperson.entity.RestaurantUser;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class RestaurantRegisterActivity extends Activity {

	private EditText etName;
	private EditText etPassword;
	private EditText etConfirmPW;
	private EditText etAddress;
	private EditText etPhone;
	private EditText etAccount;
	private EditText etIntrodution;
	private Button btnSubmit;

	RestaurantUser user;
	ApiImpl api = (ApiImpl) App.getInstance().getApi();
	
	public static void launch(Context c) {
		Intent intent = new Intent(c, RestaurantRegisterActivity.class);
		c.startActivity(intent);

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.restaurant_register_layout);
		findViewById();

	}

	private void findViewById() {
		etName = (EditText) findViewById(R.id.etName);
		etPassword = (EditText) findViewById(R.id.etPassword);
		etConfirmPW = (EditText) findViewById(R.id.etConfirmPW);
		etAddress = (EditText) findViewById(R.id.etAddress);
		etPhone = (EditText) findViewById(R.id.etPhone);
		etAccount = (EditText) findViewById(R.id.etAccount);
		etIntrodution = (EditText) findViewById(R.id.etIntroduction);
		btnSubmit = (Button) findViewById(R.id.btnSubmit);
		btnSubmit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				fillUser();
				if (api.register(user) == true) {
					System.out.println("ע��ɹ���������ת");
				} else {
					System.out.println("ע��ʧ�ܣ���Ϣ��ʾ");
				}

			}
		});
	}

	protected void fillUser() {
		if (checkPassword() == false)
			return;
		user.setUsername(etName.getText().toString());
		user.setPassword(etPassword.getText().toString());
		user.setAddress(etAddress.getText().toString());
		user.setPhone(etPhone.getText().toString());
		user.setAccount(etAccount.getText().toString());
		user.setIntroduction(etIntrodution.getText().toString());

		// ϵͳ�Լ�������
		user.setRegiterDate(new Date(1985, 5, 22, 12, 12, 12));
		user.setActivty(0);
		user.setAssessment(0);
		user.setGps("��γ��");
		user.setMenu_table("��Ʒ����");
		user.setMenu_trade("���׼�¼��");
		user.setTurnover(0);
	}

	/**
	 * ��������Ƿ�һ��
	 * 
	 * @return
	 */
	private boolean checkPassword() {
		if (etPassword.getText().toString()
				.equals(etConfirmPW.getText().toString()) == true)
			return true;
		return false;
	}
}

package wizard.threeperson.activity;

import java.util.Date;

import wizard.threeperson.App;
import wizard.threeperson.api.ApiImpl;
import wizard.threeperson.client.R;
import wizard.threeperson.entity.GuestUser;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class GuestRegisterActivity extends Activity {
	private EditText etName;
	private EditText etPassword;
	private EditText etConfrimPassword;
	private EditText etAddress;
	private EditText etPhone;
	private EditText etAccount;
	private EditText etType;
	private Button submitBtn;
	
	/**
	 * �û�������
	 */
	private GuestUser user;
	
	private ApiImpl api = (ApiImpl) App.getInstance().getApi();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guest_register_layout);
		findViewById();

	}

	private void filluser() {
		if (checkPassword() == false)
			return;
		user =new GuestUser(etName.getText().toString(), etPassword.getText().toString());
		user.setAccount(etAccount.getText().toString());
		user.setAddress(etAddress.getText().toString());
		user.setPassword(etPassword.getText().toString());
		user.setType(etType.getText().toString());
		user.setPhone(etPhone.getText().toString());
		
		//���������ϵͳ�Զ���������Ϣ
		user.setActivty(0);
		user.setGps("��γ��");
		user.setRegisterDate(new Date(1985, 5, 22, 12, 12, 12));
		user.setPriority(0);
		user.setMenu_trade("��ʷ���׵ı���");
		user.setTrade(0);
		user.setTurnover(0);
		
	}

	private void findViewById() {
		etName = (EditText) findViewById(R.id.etName);
		etPassword = (EditText) findViewById(R.id.etPassword);
		etConfrimPassword = (EditText) findViewById(R.id.etConfirmPW);
		etPhone = (EditText) findViewById(R.id.etPhone);
		etAddress = (EditText) findViewById(R.id.etAddress);
		etAccount = (EditText) findViewById(R.id.etAccount);
		etType = (EditText) findViewById(R.id.etType);
		submitBtn = (Button) findViewById(R.id.btnSubmit);
		submitBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				filluser();
				if(api.register(user)== true){
					System.out.println("ע��ɹ���������ת");
				}else{
					System.out.println("ע��ʧ�ܣ���ʾ��Ϣ������");
				}
			}
		});

	}

	/**
	 * ��������Ƿ�һ��
	 * 
	 * @return
	 */
	private boolean checkPassword() {
		if (etPassword.getText().toString()
				.equals(etConfrimPassword.getText().toString()) == true)
			return true;
		return false;
	}
}

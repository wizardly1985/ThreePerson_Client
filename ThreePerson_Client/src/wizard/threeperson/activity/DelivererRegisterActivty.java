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
	 * �û�������
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
	 * ���USER��������
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
		
		//���������ϵͳ�Զ���������Ϣ
		user.setActivty(0);
		user.setRegiterDate(new Date(1985, 5, 22, 12, 12, 12));
		user.setGps("��γ��");
		user.setTrade(0);
		user.setTurnover(0);
		
	}

	/**
	 * ��������Ƿ�һ��
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
					System.out.println("ע��ɹ���������ת");
				}else{
					System.out.println("ע��ʧ�ܣ���ʾ��Ϣ����");
				}
			}
		});
	}

}

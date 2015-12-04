package wizard.threeperson.activity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.http.Header;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import wizard.threeperson.App;
import wizard.threeperson.Constants;
import wizard.threeperson.api.ApiImpl;
import wizard.threeperson.client.R;
import wizard.threeperson.entity.GuestUser;
import wizard.threeperson.util.CutPicUtil;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.LauncherActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class GuestRegisterActivity extends Activity {
	private EditText etName;
	private EditText etPassword;
	private EditText etConfrimPassword;
	private EditText etAddress;
	private EditText etPhone;
	private EditText etAccount;
	private EditText etType;
	private ImageView headImageView;
	private ImageView backImageView;
	private Button submitBtn;
	private Bitmap photo;
	private File headfile = null;
	private File backfile = null;
	private boolean isHeading = false;
	private boolean isBacking = false;
	private boolean isCuting = false;

	private CutPicUtil headCutPicUtil = null;
	private CutPicUtil backCutPicUtil = null;

	/**
	 * 用户的引用
	 */
	private GuestUser user;

	private ApiImpl api = (ApiImpl) App.getInstance().getApi();

	public static void launch(Context context) {
		Intent i = new Intent(context, GuestRegisterActivity.class);
		context.startActivity(i);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setTitle("客户注册");
		setContentView(R.layout.guest_register_layout);
		findViewById();

	}

	private void filluser() {
		if (checkPassword() == false)
			return;
		user = new GuestUser(etName.getText().toString(), etPassword.getText()
				.toString());
		user.setAccount(etAccount.getText().toString());
		user.setAddress(etAddress.getText().toString());
		user.setPassword(etPassword.getText().toString());
//		user.setType(etType.getText().toString());
		user.setPhone(etPhone.getText().toString());

		// 填充其他由系统自动产生的信息
		user.setActivty(0);
		user.setGps("经纬度");
		user.setRegisterDate(new Date(1985, 5, 22, 12, 12, 12));
		user.setPriority(0);
		user.setMenu_trade("历史交易的表名");
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

		// etType = (EditText) findViewById(R.id.etType);
		submitBtn = (Button) findViewById(R.id.btnSubmit);
		submitBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				filluser();
				// if(api.register(user)== true){
				// System.out.println("注册成功，界面跳转");
				// Intent intent = new Intent(GuestRegisterActivity.this,
				// GuestHomePageActivity.class);
				// startActivity(intent);
				// }else{
				// System.out.println("注册失败，提示信息！！！");
				// Toast.makeText(GuestRegisterActivity.this, "注册失败！", 3000);
				// }

				if (headfile.exists() && headfile.length() > 0
						&& backfile.exists() && backfile.length() > 0) {
					AsyncHttpClient client = new AsyncHttpClient();
					RequestParams params = new RequestParams();
					try {
						params.put("headimage", headfile);
						params.put("backgroundimage", backfile);
						params.put("username", etName.getText().toString());
						params.put("password", etPassword.getText().toString());
						params.put("address", etAddress.getText().toString());
						params.put("phone", etPhone.getText().toString());
						params.put("account", etAccount.getText().toString());

					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					client.post(Constants.SERVLET_PATH + "GuestRegisterWebServlet",
							params, new AsyncHttpResponseHandler() {

								@Override
								public void onSuccess(int statusCode,
										Header[] headers, byte[] responseBody) {
									// TODO Auto-generated method stub
									System.out.println("上传成功！！");
								}

								@Override
								public void onFailure(int statusCode,
										Header[] headers, byte[] responseBody,
										Throwable error) {
									// TODO Auto-generated method stub
									System.out.println("上传失败！！");
								}
							});
				} else {
					System.out.println("文件不存在");
				}
			}

		});

		backImageView = (ImageView) findViewById(R.id.ivBackground);
		backImageView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				backCutPicUtil = new CutPicUtil(GuestRegisterActivity.this,
						backfile, backImageView);
				backCutPicUtil.showPicDialog();
				isBacking = true;
			}
		});
		headImageView = (ImageView) findViewById(R.id.ivHead);
		headImageView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				headCutPicUtil = new CutPicUtil(GuestRegisterActivity.this,
						headfile, headImageView);
				headCutPicUtil.showPicDialog();
				isHeading = true;
			}
		});
	}

	/**
	 * 检查密码是否一致
	 * 
	 * @return
	 */
	private boolean checkPassword() {
		if (etPassword.getText().toString()
				.equals(etConfrimPassword.getText().toString()) == true)
			return true;
		return false;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		// if(headCutPicUtil == null)
		// headCutPicUtil.doOnActivityResult(requestCode, resultCode, data);
		// if(backCutPicUtil == null)
		// backCutPicUtil.doOnActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case 1:
			if (!Environment.getExternalStorageState().equals(
					Environment.MEDIA_MOUNTED)) {
				Toast.makeText(GuestRegisterActivity.this, "SD卡不可用，请检查SD卡状态", 1)
						.show();
			}
			isCuting = true;
			if (isBacking == true)
				backCutPicUtil.startPicCut(data.getData());
			if (isHeading == true)
				headCutPicUtil.startPicCut(data.getData());
			break;
		case 2:
			File temp = new File(Environment.getExternalStorageDirectory()
					+ "/nihao.jpg");
			isCuting = true;
			if (isBacking == true)
				backCutPicUtil.startPicCut(Uri.fromFile(temp));
			if (isHeading == true)
				headCutPicUtil.startPicCut(Uri.fromFile(temp));
			break;
		case 3:
			if (data != null) {
				if (isBacking == true && isCuting == true)
					backfile = backCutPicUtil.setPicToView(data);
				if (isHeading == true && isCuting == true)
					headfile = headCutPicUtil.setPicToView(data);
				isBacking = false;
				isHeading = false;
				isCuting = false;
//				backCutPicUtil = null;
//				headCutPicUtil = null;
			}
			break;
		}

	}

}

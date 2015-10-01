package wizard.threeperson.activity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.http.Header;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import wizard.threeperson.client.R;
import wizard.threeperson.views.RemoteImageView;
import android.app.Activity;
import android.app.AlertDialog;
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
import android.widget.Toast;

public class RestaurantNewFoodActivity extends Activity {
	private RemoteImageView iv;
	private Bitmap photo;
	private Button publishBtn;
	private EditText etName;
	private EditText etPrice;
	private EditText etWeight;
	private EditText etIntrodution;
	private File file = null;

	public static void launch(Context c) {
		Intent intent = new Intent(c, RestaurantNewFoodActivity.class);
		c.startActivity(intent);

	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.restaurant_newfood_layout);
		
		etIntrodution = (EditText) findViewById(R.id.etIntrodution);
		etName = (EditText) findViewById(R.id.etName);
		etPrice=(EditText) findViewById(R.id.etPrice);
		etWeight = (EditText) findViewById(R.id.etWeight);

		iv = (RemoteImageView) findViewById(R.id.remoteImageView);
		iv.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showPicDialog();
			}

		});

		publishBtn = (Button) findViewById(R.id.publishBtn);
		publishBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//				File file = new File("/data/3.png");
//				File file = new File(photo);
				if (file.exists() && file.length() > 0) {
					AsyncHttpClient client = new AsyncHttpClient();
					RequestParams params = new RequestParams();
					try {
						params.put("profile_picture", file);
						params.put("name", etName.getText().toString());
						params.put("price", etPrice.getText().toString());
						params.put("type", "中餐");
						params.put("weight", etWeight.getText().toString());
						params.put("introduction", etIntrodution.getText().toString());
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					client.post(
							"http://10.0.2.2:8080/ThreePerson_Server/servlet/NewFoodWebServlet",
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
				}else{
					System.out.println("文件不存在");
				}
			}
		});

	}

	/**
	 * 显示选择的对话框
	 */
	public void showPicDialog() {
		new AlertDialog.Builder(this)
				.setTitle("选择照片")
				.setIcon(android.R.drawable.ic_dialog_info)
				.setMessage("请选择头像的方式？")
				.setNegativeButton("相册", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						Intent intent = new Intent(Intent.ACTION_PICK, null);
						intent.setDataAndType(
								MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
								"image/*");
						startActivityForResult(intent, 1);
					}
				})
				.setPositiveButton("拍照", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						Intent intent2 = new Intent(
								MediaStore.ACTION_IMAGE_CAPTURE);
						intent2.putExtra(MediaStore.EXTRA_OUTPUT, Uri
								.fromFile(new File(Environment
										.getExternalStorageDirectory(),
										"nihao.jpg")));
						startActivityForResult(intent2, 2);
					}

				}).show();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case 1:
			if (!Environment.getExternalStorageState().equals(
					Environment.MEDIA_MOUNTED)) {
				Toast.makeText(RestaurantNewFoodActivity.this,
						"SD卡不可用，请检查SD卡状态", 1).show();
			}
			startPicCut(data.getData());
			break;
		case 2:
			File temp = new File(Environment.getExternalStorageDirectory()
					+ "/nihao.jpg");
			startPicCut(Uri.fromFile(temp));
			break;
		case 3:
			if (data != null) {
				setPicToView(data);
			}
			break;
		}
	}

	/**
	 * 裁剪图片的方法
	 * 
	 * @param uri
	 */
	public void startPicCut(Uri uri) {
		Intent intentCarema = new Intent("com.android.camera.action.CROP");
		intentCarema.setDataAndType(uri, "image/*");
		intentCarema.putExtra("crop", true);
		intentCarema.putExtra("aspectX", 1);
		intentCarema.putExtra("aspectY", 1);
		// outputX outputY 是裁剪图片的宽高
		intentCarema.putExtra("outputX", 150);
		intentCarema.putExtra("outputY", 150);
		intentCarema.putExtra("return-data", true);
		startActivityForResult(intentCarema, 3);
	}

	/**
	 * 保存裁剪后的图片
	 * 
	 * @param picData
	 */
	private void setPicToView(Intent picData) {
		Bundle bundle = picData.getExtras();
		if (bundle != null) {
			photo = bundle.getParcelable("data");
			iv.setImageBitmap(photo);
//			File file = new File("/data/3.png");
			
			try {
				file = File.createTempFile("phono", "ime");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				FileOutputStream out=new FileOutputStream(file);
				photo.compress(CompressFormat.JPEG, 50, out);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}

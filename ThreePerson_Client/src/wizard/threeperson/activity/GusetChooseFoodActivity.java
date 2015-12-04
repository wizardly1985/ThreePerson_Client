package wizard.threeperson.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.io.PrintStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import wizard.threeperson.App;
import wizard.threeperson.adapter.GuestChooseFoodAdapter;
import wizard.threeperson.adapter.GuestChooseFoodAdapter.FoodCallBack;
import wizard.threeperson.adapter.MenuAdapter;
import wizard.threeperson.adapter.MenuAdapter.MenuCallBack;
import wizard.threeperson.api.ApiImpl;
import wizard.threeperson.client.R;
import wizard.threeperson.entity.Food;

/**
 * @author Ly
 *
 */
public class GusetChooseFoodActivity extends Activity implements
		PullToRefreshBase.OnRefreshListener<ListView> {

	GuestChooseFoodAdapter adapter;
	ApiImpl api = (ApiImpl) App.getInstance().getApi();
	FoodCallBack foodCallBack = new FoodCallBack();
	PullToRefreshListView lv;
	MenuAdapter menuAdapter;
	MenuCallBack menuCallBack = new MenuCallBack();
	ListView menuListView;
	Button orderBtn;
	protected ProgressDialog progressDialog;
	SlidingMenu slidingMenu;
	TextView tvCost;

	// public GusetChooseFoodActivity() {
	// FoodCallBack localFoodCallBack = new FoodCallBack();
	// this.foodCallBack = localFoodCallBack;
	// MenuCallBack localMenuCallBack = new MenuCallBack();
	// this.menuCallBack = localMenuCallBack;
	// ApiImpl localApiImpl = (ApiImpl) App.getInstance().getApi();
	// this.api = localApiImpl;
	// }

	private void initView() {

		this.tvCost = (TextView) findViewById(R.id.tvCost);
		this.orderBtn = (Button) findViewById(R.id.payBtn);
		orderBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				GuestAffirmOrderActivity.launch(GusetChooseFoodActivity.this);
			}
		});
	}

	public static void launch(Context paramContext) {
		Intent localIntent = new Intent(paramContext,
				GusetChooseFoodActivity.class);
		paramContext.startActivity(localIntent);
	}

	private void loadSlidingMenu() {
		SlidingMenu localSlidingMenu = new SlidingMenu(this);
		this.slidingMenu = localSlidingMenu;
		this.slidingMenu.setMode(0);
		this.slidingMenu.setBehindOffsetRes(R.dimen.sliding_menu_offset);
		this.slidingMenu.setTouchModeAbove(1);
		this.slidingMenu.attachToActivity(this, 1);
		this.slidingMenu.setMenu(R.layout.slidingmenu);
		ListView localListView1 = (ListView) this.slidingMenu
				.findViewById(R.id.listView1);
		this.menuListView = localListView1;
		MenuCallBack localMenuCallBack = this.menuCallBack;
		MenuAdapter localMenuAdapter1 = MenuAdapter.getInstance(this,
				localMenuCallBack);
		this.menuAdapter = localMenuAdapter1;
		ListView localListView2 = this.menuListView;
		MenuAdapter localMenuAdapter2 = this.menuAdapter;
		localListView2.setAdapter(localMenuAdapter2);
	}

	private void setupListViewListener() {
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub

			}
		});
	}

	protected void closeProgressDialog() {
		if (this.progressDialog == null)
			return;
		this.progressDialog.dismiss();
	}

	protected void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setTitle("选餐");
		setContentView(R.layout.guest_choose_layout);
		this.lv = (PullToRefreshListView) findViewById(R.id.lv);
		this.lv.setRefreshingLabel("获取更多美食");
		PullToRefreshBase.Mode localMode = PullToRefreshBase.Mode.BOTH;
		lv.setMode(localMode);
		this.lv.setOnRefreshListener(this);
		adapter = new GuestChooseFoodAdapter(this, foodCallBack);
		lv.setAdapter(adapter);
		initView();
		setupListViewListener();
		loadSlidingMenu();
		showProgressDialog();
		new GetDataTask().execute();
//		closeProgressDialog();
	}

	@SuppressLint({ "NewApi" })
	public boolean onCreateOptionsMenu(Menu paramMenu) {
		// getMenuInflater().inflate(2131492865, paramMenu);
		// MenuItem localMenuItem1 = paramMenu.add("Action Button");
		// localMenuItem1.setShowAsAction(1);
		// MenuItem localMenuItem2 = localMenuItem1.setIcon(17301577);
		return true;
	}

	public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
		switch (paramInt) {
		default:
		case 82:
		}
		while (true) {
			this.slidingMenu.toggle(true);
			return super.onKeyDown(paramInt, paramKeyEvent);
		}
	}

	public void onRefresh(PullToRefreshBase<ListView> paramPullToRefreshBase) {
		System.out.println("是不是刷新");
		// GetDataTask localGetDataTask = new GetDataTask(null);
		// Void[] arrayOfVoid = new Void[0];
		// AsyncTask localAsyncTask = localGetDataTask.execute(arrayOfVoid);
		new GetDataTask().execute();
	}

	protected void showProgressDialog() {
		if ((!isFinishing()) && (this.progressDialog == null)) {
			this.progressDialog = new ProgressDialog(this);
		}
		String str1 = getString(R.string.loadTitle);
		progressDialog.setTitle(str1);
		String str2 = getString(R.string.LoadContent);
		progressDialog.setMessage(str2);
		this.progressDialog.show();
	}

	class FoodCallBack implements GuestChooseFoodAdapter.FoodCallBack {

		public void chooseFood(Food paramFood, int paramInt) {
			PrintStream localPrintStream = System.out;
			StringBuilder localStringBuilder = new StringBuilder("点了").append(
					paramInt).append("份");
			String str1 = paramFood.getName();
			String str2 = str1;
			localPrintStream.println(str2);
			GusetChooseFoodActivity.this.menuAdapter.updateMenu(paramFood,
					paramInt);
			GusetChooseFoodActivity.this.menuAdapter.notifyDataSetChanged();
		}
	}

	private class GetDataTask extends AsyncTask<Void, Void, Void> {

		protected Void doInBackground(Void[] paramArrayOfVoid) {
			System.out.println("异步任务");
			int i = GusetChooseFoodActivity.this.adapter.getCount();
			int j = 0 + i;
			String str1 = GusetChooseFoodActivity.this.api.chooseFood(j, 5);
			try {
				JSONArray localJSONArray = new JSONObject(str1)
						.getJSONArray("info");
				int k = 0;
				while (true) {
					int m = localJSONArray.length();
					if (k >= m)
						return null;
					Food localFood1 = new Food();
					String str2 = localJSONArray.get(k).toString();
					Food localFood2 = localFood1.fromJSONString(str2);
					GusetChooseFoodActivity.this.adapter.getFood(localFood2);
					k += 1;
				}
			} catch (JSONException localJSONException) {
				while (true)
					localJSONException.printStackTrace();
			}
		}

		protected void onPostExecute(Void paramVoid) {
			GusetChooseFoodActivity.this.adapter.notifyDataSetChanged();
			GusetChooseFoodActivity.this.lv.onRefreshComplete();
			closeProgressDialog();
			super.onPostExecute(paramVoid);
		}

		protected void onPreExecute() {
			super.onPreExecute();
		}
	}

	class MenuCallBack implements MenuAdapter.MenuCallBack {

		public void totalCost(double paramDouble) {
			PrintStream localPrintStream = System.out;
			StringBuilder localStringBuilder = new StringBuilder("显示总价：");
			String str1 = String.valueOf(paramDouble).toString();
			String str2 = str1;
			localPrintStream.println(str2);
			TextView localTextView = GusetChooseFoodActivity.this.tvCost;
			String str3 = String.valueOf(paramDouble).toString();
			localTextView.setText(str3);
		}
	}
}
package wizard.threeperson.activity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import wizard.threeperson.App;
import wizard.threeperson.adapter.GuestChooseFoodAdapter;
import wizard.threeperson.adapter.MenuAdapter;
import wizard.threeperson.api.ApiImpl;
import wizard.threeperson.client.R;
import wizard.threeperson.entity.Food;
import android.R.integer;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class GusetChooseFoodActivity extends Activity implements
		OnRefreshListener<ListView> {

	PullToRefreshListView lv;
	GuestChooseFoodAdapter adapter;
	SlidingMenu slidingMenu;
	ListView menuListView;
	MenuAdapter menuAdapter;
	protected ProgressDialog progressDialog;

	TextView tvCost;
	Button orderBtn;

	FoodCallBack foodCallBack = new FoodCallBack();
	MenuCallBack menuCallBack = new MenuCallBack();
	ApiImpl api = (ApiImpl) App.getInstance().getApi();

	public static void launch(Context context) {
		Intent i = new Intent(context, GusetChooseFoodActivity.class);
		context.startActivity(i);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("选餐");
		setContentView(R.layout.guest_choose_layout);

		lv = (PullToRefreshListView) findViewById(R.id.lv);
		lv.setRefreshingLabel("获取更多美食");
		lv.setMode(Mode.BOTH);
		lv.setOnRefreshListener(this);
		adapter = new GuestChooseFoodAdapter(this, foodCallBack);
		lv.setAdapter(adapter);
		initView();
		setupListViewListener();
		loadSlidingMenu();

		new GetDataTask().execute();

	}

	private void initView() {
		// TODO Auto-generated method stub
		tvCost = (TextView) findViewById(R.id.tvCost);
		orderBtn=(Button) findViewById(R.id.payBtn);
		orderBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				GuestAffirmOrderActivity.launch(GusetChooseFoodActivity.this);
			}
		});
	}

	private void setupListViewListener() {
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				//Item的点击事件
			}
		});

	}

	private void loadSlidingMenu() {
		slidingMenu = new SlidingMenu(this);
		slidingMenu.setMode(SlidingMenu.LEFT);
		slidingMenu.setBehindOffsetRes(R.dimen.sliding_menu_offset);
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		slidingMenu.setMenu(R.layout.slidingmenu);
		menuListView = (ListView) slidingMenu.findViewById(R.id.listView1);
		menuAdapter = MenuAdapter.getInstance(this, menuCallBack);
		menuListView.setAdapter(menuAdapter);
	}

	/**
	 * 下拉刷新时调用
	 */
	@Override
	public void onRefresh(PullToRefreshBase<ListView> refreshView) {
		System.out.println("是不是刷新");
		new GetDataTask().execute();

	}

	/**
	 * @author Ly 内部类，异步从服务器读取数据
	 *
	 */
	private class GetDataTask extends AsyncTask<Void, Void, Void> {
		//
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			// showProgressDialog();
		}

		@Override
		protected Void doInBackground(Void... params) {
			System.out.println("异步任务");

			int from = 0;
			from += adapter.getCount();
			int scale = 5;
			String string = api.chooseFood(from, scale);
			JSONObject jsonObject;
			try {
				jsonObject = new JSONObject(string);

				JSONArray jsonArray = jsonObject.getJSONArray("info");
				for (int i = 0; i < jsonArray.length(); i++) {
					Food f = new Food().fromJSONString(jsonArray.get(i)
							.toString());
					adapter.getFood(f);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@SuppressWarnings("unused")
		protected void onPostExecute(Void result) {
			// closeProgressDialog();

			adapter.notifyDataSetChanged();

			// 当数据加载完成，需要调用onRefreshComplete.
			lv.onRefreshComplete();
			super.onPostExecute(result);
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_MENU:
			slidingMenu.toggle(true);
			break;
		default:
			break;
		}
		return super.onKeyDown(keyCode, event);
	}

	@SuppressLint("NewApi")
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main2, menu);

		MenuItem actionItem = menu.add("Action Button");

		actionItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		actionItem.setIcon(android.R.drawable.ic_menu_preferences);

		return true;
	}

	/**
	 * @author Ly 回调
	 *
	 */
	class FoodCallBack implements GuestChooseFoodAdapter.FoodCallBack {

		@Override
		public void chooseFood(Food f, int n) {
			System.out.println("点了" + n + "份" + f.getName());
			menuAdapter.updateMenu(f, n);
			menuAdapter.notifyDataSetChanged();
		}
	}

	class MenuCallBack implements MenuAdapter.MenuCallBack {

		@Override
		public void totalCost(double cost) {
			// TODO Auto-generated method stub
			System.out.println("显示总价：" + String.valueOf(cost).toString());
			tvCost.setText(String.valueOf(cost).toString());
		}

	}

	/**
	 * 显示
	 */
	protected void showProgressDialog() {
		if ((!isFinishing()) && (this.progressDialog == null)) {
			this.progressDialog = new ProgressDialog(this);
		}
		this.progressDialog.setTitle(getString(R.string.loadTitle));
		this.progressDialog.setMessage(getString(R.string.LoadContent));
		this.progressDialog.show();
	}

	/**
	 * 关闭
	 */
	protected void closeProgressDialog() {
		if (this.progressDialog != null)
			this.progressDialog.dismiss();
	}

}

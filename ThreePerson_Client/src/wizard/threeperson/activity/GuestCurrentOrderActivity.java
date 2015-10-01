package wizard.threeperson.activity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import wizard.threeperson.App;
import wizard.threeperson.adapter.GusetCurrentOrderAdapter;
import wizard.threeperson.api.ApiImpl;
import wizard.threeperson.client.R;
import wizard.threeperson.entity.Order;
import wizard.threeperson.entity.Trade;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;

public class GuestCurrentOrderActivity extends Activity implements
		OnRefreshListener<ListView> {
	private PullToRefreshListView lv;
	GusetCurrentOrderAdapter adapter;
	ApiImpl api = (ApiImpl) App.getInstance().getApi();

	public static void launch(Context context) {
		Intent i = new Intent(context, GuestCurrentOrderActivity.class);
		context.startActivity(i);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guest_currentorder_layout);
		setTitle("当前的订单");
		lv = (PullToRefreshListView) findViewById(R.id.lv);
		lv.setOnRefreshListener(this);
		setupListViewListener();
		
		adapter = new GusetCurrentOrderAdapter(this);
		lv.setAdapter(adapter);
		
		new GetDataTask().execute();
	}

	private void setupListViewListener() {
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				System.out.println(arg2);
				System.out.println(arg3);
				
			}
		});
	}
	
	class GetDataTask extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			System.out.println("异步任务");
			
			int from = 0;
			from += adapter.getCount();
			int scale = 1;
			String string = api.currentOrder(from, scale);
			JSONObject jsonObject;
			try {
				jsonObject = new JSONObject(string);

				JSONArray jsonArray = jsonObject.getJSONArray("info");
				System.out.println("解析："+jsonArray.length());
				for (int i = 0; i < jsonArray.length(); i++) {
					Order order = new Order().fromJSONString(jsonArray.get(i)
							.toString());
					adapter.getOrder(order);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			adapter.notifyDataSetChanged();
			lv.onRefreshComplete();
			System.out.println(adapter.getCount());
			super.onPostExecute(result);
		}
	}

	@Override
	public void onRefresh(PullToRefreshBase<ListView> refreshView) {
		// TODO Auto-generated method stub
		new GetDataTask().execute();
	}
}

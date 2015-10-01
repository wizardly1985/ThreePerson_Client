package wizard.threeperson.activity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import wizard.threeperson.App;
import wizard.threeperson.adapter.GuestAllTradeAdapter;
import wizard.threeperson.api.ApiImpl;
import wizard.threeperson.client.R;
import wizard.threeperson.entity.Trade;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

public class GuestAllTradeActivity extends Activity implements
		OnRefreshListener<ListView> {
	
	PullToRefreshListView lv;
	GuestAllTradeAdapter adapter;
	ApiImpl api = (ApiImpl) App.getInstance().getApi();

	
	public static void launch(Context context) {
		Intent i = new Intent(context, GuestAllTradeActivity.class);
		context.startActivity(i);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("交易记录");
		setContentView(R.layout.guest_alltrade_layout);
		lv = (PullToRefreshListView) findViewById(R.id.lv);
		lv.setOnRefreshListener(this);
		setupListViewListener();

		adapter = new GuestAllTradeAdapter(this);
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

	@Override
	public void onRefresh(PullToRefreshBase<ListView> refreshView) {
		
		new GetDataTask().execute();
	}
	
	/**
	 * @author Ly
	 * 内部类，异步从服务器读取数据
	 *
	 */
	private class GetDataTask extends AsyncTask<Void, Void, Void> {
		//
		@Override
		protected Void doInBackground(Void... params) {
			System.out.println("异步任务");
			
			int from = 0;
			from += adapter.getCount();
			int scale = 2;
			String string = api.allTrade(from, scale);
			JSONObject jsonObject;
			try {
				jsonObject = new JSONObject(string);

				JSONArray jsonArray = jsonObject.getJSONArray("info");
				System.out.println("解析："+jsonArray.length());
				for (int i = 0; i < jsonArray.length(); i++) {
					Trade t = new Trade().fromJSONString(jsonArray.get(i)
							.toString());
					System.out.println(t.toJSONString());
					adapter.getTrade(t);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@SuppressWarnings("unused")
		protected void onPostExecute(Void result) {
			adapter.notifyDataSetChanged();

			// 当数据加载完成，需要调用onRefreshComplete.
			lv.onRefreshComplete();
			System.out.println("异步任务完成@@@");

			super.onPostExecute(result);
		}
	}
}

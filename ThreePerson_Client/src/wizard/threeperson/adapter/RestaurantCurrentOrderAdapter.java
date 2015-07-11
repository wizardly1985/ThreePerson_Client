package wizard.threeperson.adapter;

import wizard.threeperson.client.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class RestaurantCurrentOrderAdapter extends BaseAdapter {

	private Context mContext;
	public RestaurantCurrentOrderAdapter(Context context) {
		super();
		this.mContext = context;
	}

	@Override
	public int getCount() {
		return 5;
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 1;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		arg1 = LayoutInflater.from(mContext).inflate(R.layout.restaurant_currentorder_listview_layout, null);
//		TextView tv1 = (TextView) arg1.findViewById(R.id.textView1);
//		TextView tv2 =(TextView) arg1.findViewById(R.id.textView2);
//		tv1.setText(mUsers.get(arg0).getName());
//		tv2.setText(mUsers.get(arg0).getAddress());
		return arg1;
	}

}

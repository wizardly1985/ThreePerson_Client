package wizard.threeperson.adapter;

import wizard.threeperson.client.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class DelivererAllTradeAdapter extends BaseAdapter {
	private Context mContext;

	public DelivererAllTradeAdapter(Context mContext) {
		super();
		this.mContext = mContext;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 7;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		arg1 = LayoutInflater.from(mContext).inflate(R.layout.deliverer_alltrade_listview_layout, null);
		return arg1;
	}

}

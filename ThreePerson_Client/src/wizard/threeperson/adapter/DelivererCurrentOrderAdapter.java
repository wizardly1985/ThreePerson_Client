package wizard.threeperson.adapter;

import wizard.threeperson.client.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class DelivererCurrentOrderAdapter extends BaseAdapter {
	private Context mContext;

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 4;
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

	public DelivererCurrentOrderAdapter(Context mContext) {
		super();
		this.mContext = mContext;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		arg1=LayoutInflater.from(mContext).inflate(R.layout.deliverer_currentorder_listview_layout, null);
		return arg1;
	}

}

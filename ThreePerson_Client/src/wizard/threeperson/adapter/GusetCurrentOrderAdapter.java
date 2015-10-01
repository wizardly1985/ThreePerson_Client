package wizard.threeperson.adapter;

import java.util.ArrayList;
import java.util.List;

import wizard.threeperson.client.R;
import wizard.threeperson.entity.Order;
import wizard.threeperson.entity.Trade;
import wizard.threeperson.views.RemoteImageView;
import android.R.integer;
import android.content.Context;
import android.provider.Telephony.Mms.Addr;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GusetCurrentOrderAdapter extends BaseAdapter {
	private Context mContext;
	private List<Order> orders= new ArrayList<Order>();

	public GusetCurrentOrderAdapter(Context mContext) {
		super();
		this.mContext = mContext;
	}

	@Override
	public int getCount() {
		return orders.size();
	}

	@Override
	public Object getItem(int arg0) {
		return orders.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		arg1 = LayoutInflater.from(mContext).inflate(R.layout.guest_currentorder_listview_layout, null);
		
		RemoteImageView iv=(RemoteImageView) arg1.findViewById(R.id.iv);
		TextView tvFood=(TextView) arg1.findViewById(R.id.tvFood);
		TextView tvPrice=(TextView) arg1.findViewById(R.id.tvPrice);
		TextView tvStatus=(TextView) arg1.findViewById(R.id.tvStatus);
		TextView tvRestName=(TextView) arg1.findViewById(R.id.tvRestName);
		TextView tvRestAddress=(TextView) arg1.findViewById(R.id.tvRestAddress);
		TextView tvRestPhone=(TextView) arg1.findViewById(R.id.tvRestPhone);
		TextView tvDeliverer=(TextView) arg1.findViewById(R.id.deliverer);
		
		Order order = new Order();
		if ((order = orders.get(arg0)) != null ) {
			tvFood.setText("菜名:" + order.getFoodName());
			tvPrice.setText("价格:" + order.getPrice());
			tvStatus.setText("状态:" + order.getStatus());
			tvRestName.setText("店名:" + order.getRestaurant_name());
			tvRestAddress.setText("地址:" + order.getRestaurant_address());
			tvRestPhone.setText("电话:" + order.getRestaurant_phone());
			tvDeliverer.setText("配送员:" + order.getDeliverer_name()+"      "+"电话:"+order.getDeliverer_phone());
			
			iv.setBackgroundResource(R.drawable.mydefault);
		}
		return arg1;
	}
	
	public void getOrder(Order order) {
		orders.add(order);
	}

}

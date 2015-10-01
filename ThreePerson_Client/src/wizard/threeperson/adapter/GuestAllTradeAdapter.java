package wizard.threeperson.adapter;

import java.util.ArrayList;
import java.util.List;

import wizard.threeperson.client.R;
import wizard.threeperson.entity.Food;
import wizard.threeperson.entity.Trade;
import wizard.threeperson.views.RemoteImageView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class GuestAllTradeAdapter extends BaseAdapter {

	private Context mContext;
	private List<Trade> trades = new ArrayList<Trade>();

	public GuestAllTradeAdapter(Context mContext) {
		super();
		this.mContext = mContext;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		System.out.println("共："+trades.size());
		return trades.size();
//		return 1;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return trades.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		System.out.println("getview!!!");
		arg1 = LayoutInflater.from(mContext).inflate(
				R.layout.guest_alltrade_listview_layout, null);
		RemoteImageView iv=(RemoteImageView) arg1.findViewById(R.id.iv);
		TextView tvName=(TextView) arg1.findViewById(R.id.tvName);
		TextView tvPrice=(TextView) arg1.findViewById(R.id.tvPrice);
		TextView tvAssess=(TextView) arg1.findViewById(R.id.tvAssess);
		TextView tvBookTime=(TextView) arg1.findViewById(R.id.tvBookTime);
		TextView tvAchieveTime=(TextView) arg1.findViewById(R.id.tvAchieveTime);
		
		System.out.println("!!"+arg0);
		
		Trade trade = new Trade();
		if ((trade = trades.get(arg0)) != null ) {
			tvName.setText("菜名:" + trade.getFood());
			tvPrice.setText("价格:" + trade.getPrice());
//			tvAssess.setText("评价:"+trade.get);
			tvBookTime.setText("下单时间:"+trade.getBook_time().toString());
			tvAchieveTime.setText("完成时间:"+trade.getAchieve_time().toString());
			iv.setBackgroundResource(R.drawable.mydefault);
		}
		System.out.println("viewlayout:"+arg1.getId());
		return arg1;
	}

	public void getTrade(Trade t) {
		System.out.println("加个trade");
		trades.add(t);
	}

}

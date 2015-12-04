package wizard.threeperson.adapter;

import java.util.ArrayList;
import java.util.List;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import wizard.threeperson.Constants;
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

	DisplayImageOptions options;
	protected ImageLoader imageLoader = ImageLoader.getInstance();
	
	public GusetCurrentOrderAdapter(Context mContext) {
		super();
		this.mContext = mContext;
		
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				mContext).threadPriority(Thread.NORM_PRIORITY - 2)
				.denyCacheImageMultipleSizesInMemory()
				.discCacheFileNameGenerator(new Md5FileNameGenerator())
				.tasksProcessingOrder(QueueProcessingType.LIFO).enableLogging() 
				.build();
		// Initialize ImageLoader with configuration.
		ImageLoader.getInstance().init(config);
		options = new DisplayImageOptions.Builder()
				.showStubImage(R.drawable.mydefault)
				.showImageForEmptyUri(R.drawable.mydefault)
				.showImageOnFail(R.drawable.mydefault).cacheInMemory()
				.cacheOnDisc().displayer(new RoundedBitmapDisplayer(20))
				.build();
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
			tvFood.setText("����:" + order.getFoodName());
			tvPrice.setText("�۸�:" + order.getPrice());
			tvStatus.setText("״̬:" + order.getStatus());
			tvRestName.setText("����:" + order.getRestaurant_name());
			tvRestAddress.setText("��ַ:" + order.getRestaurant_address());
			tvRestPhone.setText("�绰:" + order.getRestaurant_phone());
			tvDeliverer.setText("����Ա:" + order.getDeliverer_name()+"      "+"�绰:"+order.getDeliverer_phone());
			
//			iv.loadImage(Constants.IMAGE_PATH+order.getImage());
			imageLoader.displayImage(
					Constants.IMAGE_PATH+order.getImage(), iv, options);
		}
		return arg1;
	}
	
	public void getOrder(Order order) {
		orders.add(order);
	}

}

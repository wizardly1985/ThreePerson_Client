package wizard.threeperson.api;

import android.R.integer;
import android.os.Handler;
import android.util.Log;
import wizard.threeperson.Constants;
import wizard.threeperson.entity.AbsUser;
import wizard.threeperson.entity.DelivererUser;
import wizard.threeperson.entity.Food;
import wizard.threeperson.entity.GuestUser;
import wizard.threeperson.entity.RestaurantUser;
import wizard.threeperson.util.HttpUtils;

public class ApiImpl implements IApi {
	private String PATH = Constants.SERVLET_PATH;
//	private String PATH = "http://10.0.2.2:8080/ThreePerson_Server/servlet/";
	private static ApiImpl apiImpl = null;

	public static ApiImpl getIntance() {
		if (apiImpl == null) {
			apiImpl = new ApiImpl();
			return apiImpl;
		}
		return apiImpl;

	}

	/**
	 * 制造Servlet的访问路径
	 * 
	 * @param servletName
	 * @return
	 */
	private String buildString(String servletName) {
		return PATH + servletName;

	}

	// 实现登陆
	public GuestUser login(GuestUser user) {
		String servletString = "LoginServlet";
		String servletPath = buildString(servletString);
		String result = HttpUtils.sendPostMessage(servletPath,
				user.toJSONString());
		user.fromJSONString(result);
		System.out.println("--->>" + user.getPassword());
		System.out.println("--->>" + user.getPhone());
		System.out.println("--->>" + user.getAddress());
		return user;
	}

	@Override
	public boolean register(AbsUser user) {
		String servletString = "RegisterServlet";
		String servletPath = buildString(servletString);
		String result = HttpUtils.sendPostMessage(servletPath,
				user.toJSONString());
		return false;
	}

	@Override
	public String homePage(AbsUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editUserinfo(AbsUser user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void showUserdetail(AbsUser user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void newFood(RestaurantUser user, Food food) {
		// TODO Auto-generated method stub

	}

	@Override
	public String currentOrder(int from, int scale) {
		String servletString = "CurrentOrderServlet";
		String servletPath = buildString(servletString);
		StringBuffer valuesBuilder = new StringBuffer();
		valuesBuilder.append("from=");
		valuesBuilder.append(from);
		valuesBuilder.append("&");
		valuesBuilder.append("scale=");
		valuesBuilder.append(scale);
		String str = valuesBuilder.toString();
		System.out.println(str);
		String result = HttpUtils.sendPostMessage(servletPath, str);
		return result;

	}

	@Override
	public String allTrade(int from, int scale) {
		String servletString = "AllTradeServlet";
		String servletPath = buildString(servletString);
		StringBuffer valuesBuilder = new StringBuffer();
		valuesBuilder.append("from=");
		valuesBuilder.append(from);
		valuesBuilder.append("&");
		valuesBuilder.append("scale=");
		valuesBuilder.append(scale);
		String str = valuesBuilder.toString();
		System.out.println(str);
		String result = HttpUtils.sendPostMessage(servletPath, str);
		return result;
	}

	@Override
	public String chooseFood(int from, int scale) {
		String servletString = "ChooseFoodServlet";
		String servletPath = buildString(servletString);
		StringBuffer valuesBuilder = new StringBuffer();
		valuesBuilder.append("from=");
		valuesBuilder.append(from);
		valuesBuilder.append("&");
		valuesBuilder.append("scale=");
		valuesBuilder.append(scale);
		String str = valuesBuilder.toString();
		System.out.println(str);
		String result = HttpUtils.sendPostMessage(servletPath, str);
		return result;
	}

	@Override
	public void publishOrder(String jsonString) {
		String servletString = "PublishOrderServlet";
		String servletPath = buildString(servletString);
		String result = HttpUtils.sendPostMessage(servletPath,
				jsonString);
	}

	@Override
	public void acceptOrder(DelivererUser user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void finishOrder(DelivererUser user) {
		// TODO Auto-generated method stub

	}

	

}

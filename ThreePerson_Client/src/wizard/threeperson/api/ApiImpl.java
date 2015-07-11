package wizard.threeperson.api;

import android.os.Handler;
import android.util.Log;
import wizard.threeperson.entity.AbsUser;
import wizard.threeperson.entity.DelivererUser;
import wizard.threeperson.entity.Food;
import wizard.threeperson.entity.GuestUser;
import wizard.threeperson.entity.RestaurantUser;
import wizard.threeperson.util.HttpUtils;

public class ApiImpl implements IApi {
	private String PATH = "http://10.0.2.2:8080/ThreePerson_Server/servlet/";
	private static ApiImpl apiImpl = null;

	public static ApiImpl getIntance() {
		if (apiImpl == null) {
			return new ApiImpl();
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
	public AbsUser login(AbsUser user) {
		String servletString = "LoginServlet";
		String servletPath = buildString(servletString);
		String result = HttpUtils.sendPostMessage(servletPath,
				user.toJSONString());
		Log.v("wizard_ly", result);
//		user.fromJSONString(result);
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
	public void currentOrder(AbsUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void allTrade(AbsUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chooseFood(GuestUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void publishOrder(GuestUser user) {
		// TODO Auto-generated method stub
		
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

package wizard.threeperson;

import wizard.threeperson.api.ApiImpl;
import wizard.threeperson.api.IApi;
import wizard.threeperson.entity.AbsUser;
import wizard.threeperson.entity.GuestUser;
import wizard.threeperson.entity.RestaurantUser;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class App extends Application {

	// 是否第一次启动
	private boolean isFirstIn = false;
	// 是否登陆
	private boolean isLogin = false;
	// 有用户信息
	private boolean hasUser = false;;
	// 是否是饭店
	private boolean isRest = false;

	private static App app = null;
	private IApi api = ApiImpl.getIntance();
	private static GuestUser user = new GuestUser("岩岩", "UUU");
	private static RestaurantUser restaurantUser = null;

	public GuestUser getUser() {
		return user;
	}

	public void setUser(GuestUser user) {
		this.user = user;
		System.out.println(user.getUsername());
	}

	public void setShareXML(Context context) {
		// TODO Auto-generated method stub
		SharedPreferences preferences = context.getSharedPreferences("appinfo",
				MODE_PRIVATE);
		Editor editor = preferences.edit();
		editor.putBoolean("hasUser", true);
		editor.putString("username", user.getUsername());
		editor.putString("password", user.getPassword());
		editor.putString("account", user.getAccount());
		editor.putString("address", user.getAddress());
		editor.putInt("Activity", user.getActivty());
		editor.putString("gps", user.getGps());
		editor.putString("menu_trade", user.getMenu_trade());
		editor.putString("phone", user.getPhone());
		editor.putString("role", user.getRole());
		editor.putString("type", user.getType());
		editor.putInt("priority", user.getPriority());
		editor.putFloat("turnover", (float) user.getTurnover());
		editor.putInt("trade", user.getTrade());
		editor.commit();
	}

	/**
	 * 单例模式
	 * 
	 * @return
	 */
	public static App getInstance() {
		if (app == null) {
			app = new App();
			return app;
		}
		return app;
	}

	// 得到API实例
	public IApi getApi() {
		return api;
	}

	@Override
	public void onCreate() {
		api = ApiImpl.getIntance();

		// 初始化User
		System.out.println("————————初始化User————————");
		if (isLogin == true && hasUser == true)
			initUser();
		setUser(user);

		super.onCreate();
	}

	private void initUser() {
		// TODO Auto-generated method stub
		SharedPreferences sharedPreferences = getSharedPreferences("appinfo", MODE_PRIVATE);
		user.setUsername(sharedPreferences.getString("username", ""));
		user.setPassword(sharedPreferences.getString("password", ""));
		user.setPhone(sharedPreferences.getString("phone", ""));
		user.setType(sharedPreferences.getString("type", ""));
		user.setAddress(sharedPreferences.getString("address", ""));
		user.setTrade(sharedPreferences.getInt("trade", 0));
		user.setActivty(sharedPreferences.getInt("Activity", 0));
		user.setTurnover(sharedPreferences.getInt("turnover", 0));
		user.setPriority(sharedPreferences.getInt("priority", 0));
		user.setAccount(sharedPreferences.getString("account", ""));
		user.setMenu_trade(sharedPreferences.getString("menu_trade", ""));
		user.setGps(sharedPreferences.getString("gps", ""));

	}

	public boolean isFirstIn() {
		return isFirstIn;
	}

	public void setFirstIn(boolean isFirstIn) {
		this.isFirstIn = isFirstIn;
	}

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	public boolean isHasUser() {
		return hasUser;
	}

	public void setHasUser(boolean hasUser) {
		this.hasUser = hasUser;
	}

	public boolean isRest() {
		return isRest;
	}

	public void setRest(boolean isRest) {
		this.isRest = isRest;
	}
}

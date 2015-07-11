package wizard.threeperson;

import wizard.threeperson.api.ApiImpl;
import wizard.threeperson.api.IApi;
import wizard.threeperson.entity.AbsUser;
import android.app.Application;

public class App extends Application {
	private static App app = null;
	private IApi api = ApiImpl.getIntance();
	private AbsUser user;
	public AbsUser getUser() {
		return user;
	}

	public void setUser(AbsUser user) {
		this.user = user;
	}

	/**
	 * 单例模式
	 * 
	 * @return
	 */
	public static App getInstance() {
		if (app == null) {
			return new App();
		}
		return app;
	}

	//得到API实例
	public IApi getApi() {
		return api;
	}

	@Override
	public void onCreate() {
		api = ApiImpl.getIntance();
		super.onCreate();
	}
}

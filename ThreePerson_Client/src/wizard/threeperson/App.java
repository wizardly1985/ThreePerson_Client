package wizard.threeperson;

import wizard.threeperson.api.ApiImpl;
import wizard.threeperson.api.IApi;
import wizard.threeperson.entity.AbsUser;
import wizard.threeperson.entity.GuestUser;
import android.app.Application;

public class App extends Application {
	private static App app = null;
	private IApi api = ApiImpl.getIntance();
	private static GuestUser user = new GuestUser("����", "UUU");
	public GuestUser getUser() {
		return user;
	}

	public void setUser(GuestUser user) {
		this.user = user;
		System.out.println(user.getUsername());
	}

	/**
	 * ����ģʽ
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

	//�õ�APIʵ��
	public IApi getApi() {
		return api;
	}

	@Override
	public void onCreate() {
		api = ApiImpl.getIntance();

		//��ʼ��User
		System.out.println("������������������ʼ��User����������������");
		user.setPhone("18715901387");
		user.setAddress("��̲18255��");
		setUser(user);
		
		super.onCreate();
	}
}

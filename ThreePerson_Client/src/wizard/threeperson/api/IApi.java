package wizard.threeperson.api;

import wizard.threeperson.entity.AbsUser;
import wizard.threeperson.entity.DelivererUser;
import wizard.threeperson.entity.Food;
import wizard.threeperson.entity.GuestUser;
import wizard.threeperson.entity.RestaurantUser;

public interface IApi {

	/**
	 * 登陆接口
	 * 对应服务器端的LoginServlet
	 * @param user 创建用户，传入
	 * @return  查询服务器端的数据库，如果正确，侧返回absUser对象，否侧NULL
	 */
	public GuestUser login(GuestUser user);
	
	/**
	 * 注册用户
	 * RegisterServlet
	 * @param user
	 * @return
	 */
	public boolean register(AbsUser user);
	
	/**
	 * 取得主页信息的接口
	 * HomePageServlet
	 * @param user
	 */
	public String homePage(AbsUser user);
	
	/**
	 * 修改，编辑用户信息的接口
	 * EditUserinfoServlet
	 * @param user
	 * @return
	 */
	public boolean editUserinfo(AbsUser user);
	
	/**
	 * 取得用户详细信息的接口
	 * @param user
	 */
	public void showUserdetail(AbsUser user);
	
	/**
	 * 饭店发布新的菜品
	 * @param user 饭店
	 * @param food 菜品
	 */
	public void newFood(RestaurantUser user,Food food);
	
	/**
	 *  三种角色可通过这个调用查询当前的订单
	 * @param user
	 */
	public String currentOrder(int from, int scale);
	
	/**
	 * 三种角色通过这个调用查询所有的交易记录
	 * @param user
	 */
	public String allTrade(int from, int scale);
	
	/**
	 * 食客通过这个调用选择菜品
	 * @param user
	 */
	public String chooseFood(int from, int scale);
	
	/**
	 * 食客提交一个订单
	 * @param user
	 */
	public Boolean publishOrder(String jsonString);
	
	/**
	 * 配送员接受一个订单
	 * @param user
	 */
	public void acceptOrder(DelivererUser user);
	
	/**
	 * 配送员完成一个订单
	 * @param user
	 */
	public void finishOrder(DelivererUser user);

}

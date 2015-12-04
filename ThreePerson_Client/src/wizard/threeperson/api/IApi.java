package wizard.threeperson.api;

import wizard.threeperson.entity.AbsUser;
import wizard.threeperson.entity.DelivererUser;
import wizard.threeperson.entity.Food;
import wizard.threeperson.entity.GuestUser;
import wizard.threeperson.entity.RestaurantUser;

public interface IApi {

	/**
	 * ��½�ӿ�
	 * ��Ӧ�������˵�LoginServlet
	 * @param user �����û�������
	 * @return  ��ѯ�������˵����ݿ⣬�����ȷ���෵��absUser���󣬷��NULL
	 */
	public GuestUser login(GuestUser user);
	
	/**
	 * ע���û�
	 * RegisterServlet
	 * @param user
	 * @return
	 */
	public boolean register(AbsUser user);
	
	/**
	 * ȡ����ҳ��Ϣ�Ľӿ�
	 * HomePageServlet
	 * @param user
	 */
	public String homePage(AbsUser user);
	
	/**
	 * �޸ģ��༭�û���Ϣ�Ľӿ�
	 * EditUserinfoServlet
	 * @param user
	 * @return
	 */
	public boolean editUserinfo(AbsUser user);
	
	/**
	 * ȡ���û���ϸ��Ϣ�Ľӿ�
	 * @param user
	 */
	public void showUserdetail(AbsUser user);
	
	/**
	 * ���귢���µĲ�Ʒ
	 * @param user ����
	 * @param food ��Ʒ
	 */
	public void newFood(RestaurantUser user,Food food);
	
	/**
	 *  ���ֽ�ɫ��ͨ��������ò�ѯ��ǰ�Ķ���
	 * @param user
	 */
	public String currentOrder(int from, int scale);
	
	/**
	 * ���ֽ�ɫͨ��������ò�ѯ���еĽ��׼�¼
	 * @param user
	 */
	public String allTrade(int from, int scale);
	
	/**
	 * ʳ��ͨ���������ѡ���Ʒ
	 * @param user
	 */
	public String chooseFood(int from, int scale);
	
	/**
	 * ʳ���ύһ������
	 * @param user
	 */
	public Boolean publishOrder(String jsonString);
	
	/**
	 * ����Ա����һ������
	 * @param user
	 */
	public void acceptOrder(DelivererUser user);
	
	/**
	 * ����Ա���һ������
	 * @param user
	 */
	public void finishOrder(DelivererUser user);

}

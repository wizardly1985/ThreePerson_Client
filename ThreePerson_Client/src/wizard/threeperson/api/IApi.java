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
	public AbsUser login(AbsUser user);
	
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
	public void currentOrder(AbsUser user);
	
	/**
	 * ���ֽ�ɫͨ��������ò�ѯ���еĽ��׼�¼
	 * @param user
	 */
	public void allTrade(AbsUser user);
	
	/**
	 * ʳ��ͨ���������ѡ���Ʒ
	 * @param user
	 */
	public void chooseFood(GuestUser user);
	
	/**
	 * ʳ���ύһ������
	 * @param user
	 */
	public void publishOrder(GuestUser user);
	
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

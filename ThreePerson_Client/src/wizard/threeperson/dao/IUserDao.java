package wizard.threeperson.dao;

import wizard.threeperson.entity.AbsUser;

public interface IUserDao {
	/**
	 * �Ñ���½
	 * @param user
	 * @return
	 */
	public boolean login(AbsUser user); 
}

package wizard.threeperson.dao;

import wizard.threeperson.entity.AbsUser;

public interface IUserDao {
	/**
	 * ÓÃ‘ôµÇÂ½
	 * @param user
	 * @return
	 */
	public boolean login(AbsUser user); 
}

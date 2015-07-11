package wizard.threeperson.entity;

import java.io.Serializable;

public abstract class AbsUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String password = null;

	protected String role = null;

	protected String username = null;

	public AbsUser(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	/**
	 * 抽象方法，把json格式的字符串解析成对象
	 * @param jSONString
	 * @return
	 */
	public abstract AbsUser fromJSONString(String jSONString);

	/**
	 * 抽象方法，把对象解析成JSON的字符串
	 * @return
	 */
	public abstract String toJSONString() ;
	
	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}

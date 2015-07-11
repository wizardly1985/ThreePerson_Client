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
	 * ���󷽷�����json��ʽ���ַ��������ɶ���
	 * @param jSONString
	 * @return
	 */
	public abstract AbsUser fromJSONString(String jSONString);

	/**
	 * ���󷽷����Ѷ��������JSON���ַ���
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

package wizard.threeperson.entity;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

public class GuestUser extends AbsUser {
	/**
	 * 
	 */
	private static final long serialVersionUID = 155380339268692566L;
	private Date registerDate = new Date(0, 0, 0);
	private String address = "0";
	private String gps = "0";
	private String phone = "0";
	private String account = "0";
	private String type = "0";
	private String menu_trade = "0";
	private int trade;

	private double turnover;

	private int activty;

	private int priority;

	public GuestUser(String username, String password) {
		super(username, password, "guest");
	}

	public GuestUser(String username, String password, String role) {
		super(username, password, "guest");
	}

	public String getAccount() {
		return account;
	}

	public int getActivty() {
		return activty;
	}

	public String getAddress() {
		return address;
	}

	public String getGps() {
		return gps;
	}

	public String getMenu_trade() {
		return menu_trade;
	}

	public String getPhone() {
		return phone;
	}

	public int getPriority() {
		return priority;
	}

	public int getTrade() {
		return trade;
	}

	public double getTurnover() {
		return turnover;
	}

	public String getType() {
		return type;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setActivty(int activty) {
		this.activty = activty;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setGps(String gps) {
		this.gps = gps;
	}

	public void setMenu_trade(String menu_trade) {
		this.menu_trade = menu_trade;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public void setTrade(int trade) {
		this.trade = trade;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public void setTurnover(double turnover) {
		this.turnover = turnover;
	}

	public void setType(String type) {
		this.type = type;
	}

	@SuppressWarnings("deprecation")
	@Override
	public AbsUser fromJSONString(String jSONString) {
		try {
			JSONObject jsonObject = new JSONObject(jSONString);
			this.setUsername(jsonObject.getString("name"));
			this.setPassword(jsonObject.getString("password"));
			this.setRegisterDate(new Date(jsonObject.getString("registerDate")));
			this.setAddress(jsonObject.getString("address"));
			this.setGps(jsonObject.getString("gps"));
			this.setPhone(jsonObject.getString("phone"));
			this.setAccount(jsonObject.getString("account"));
			this.setMenu_trade(jsonObject.getString("menu_table"));
			this.setTrade(jsonObject.getInt("trade"));
			this.setActivty(jsonObject.getInt("activity"));
			this.setPriority(jsonObject.getInt("priority"));
			this.setTurnover(jsonObject.getDouble("password"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}

	/*
	 * 把该类转化成JSON数据格式
	 */
	@Override
	public String toJSONString() {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("username", getUsername());
			jsonObject.put("password", getPassword());
			jsonObject.put("role", getRole());
			jsonObject.put("address", getAddress());
			jsonObject.put("registerDate", getRegisterDate());
			jsonObject.put("gps", getGps());
			jsonObject.put("phone", getPhone());
			jsonObject.put("account", getAccount());
			jsonObject.put("type", getType());
			jsonObject.put("menu_table", getMenu_trade());
			jsonObject.put("trade", getTrade());
			jsonObject.put("turnover", getTurnover());
			jsonObject.put("activity", getActivty());
			jsonObject.put("priority", getPriority());

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonObject.toString();
	}

	@Test
	public void test() {

		GuestUser user = new GuestUser("刘德华", "djfskjdhfjskd");
		user.setRole("guest");
		user.setAddress("djfjsjdhfjs");
		user.setRegisterDate(new Date(2015, 5, 27));
		user.setGps("34'89'23'");
		user.setPhone("12468463277");
		user.setAccount("taobao");
		user.setType("大客户");
		user.setMenu_trade("kkkkkk");
		user.setTrade(12345555);
		user.setTurnover(123.98);
		user.setActivty(120);
		user.setPriority(999);
		System.out.println(user.toJSONString());
	}
}

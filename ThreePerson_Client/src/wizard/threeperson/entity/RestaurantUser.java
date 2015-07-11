package wizard.threeperson.entity;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class RestaurantUser extends AbsUser {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7518593571988840059L;
	private Date regiterDate = new Date(0, 0, 0, 0, 0, 0);
	private String address = "0";
	private String gps = "0";
	private String phone = "0";
	private String account = "0";
	private String menu_trade = "0";
	private String menu_table = "0";
	private int trade;
	private double turnover;

	private int activty;

	private String introduction;

	private String recommendation;

	private int assessment;

	public RestaurantUser(String username, String password) {
		super(username, password, "restaurant");
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

	public int getAssessment() {
		return assessment;
	}

	public String getGps() {
		return gps;
	}

	public String getIntroduction() {
		return introduction;
	}

	public String getMenu_table() {
		return menu_table;
	}

	public String getMenu_trade() {
		return menu_trade;
	}

	public String getPhone() {
		return phone;
	}

	public String getRecommendation() {
		return recommendation;
	}

	public Date getRegiterDate() {
		return regiterDate;
	}

	public int getTrade() {
		return trade;
	}

	public double getTurnover() {
		return turnover;
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

	public void setAssessment(int assessment) {
		this.assessment = assessment;
	}

	public void setGps(String gps) {
		this.gps = gps;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public void setMenu_table(String menu_table) {
		this.menu_table = menu_table;
	}

	public void setMenu_trade(String menu_trade) {
		this.menu_trade = menu_trade;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}
	public void setRegiterDate(Date regiterDate) {
		this.regiterDate = regiterDate;
	}

	public void setTrade(int trade) {
		this.trade = trade;
	}

	public void setTurnover(double turnover) {
		this.turnover = turnover;
	}

	@SuppressWarnings("deprecation")
	@Override
	public AbsUser fromJSONString(String jSONString) {
		try {
			JSONObject jsonObject = new JSONObject(jSONString);
			this.setUsername(jsonObject.getString("name"));
			this.setPassword(jsonObject.getString("password"));
			this.setRegiterDate(new Date(jsonObject.getString("register")));
			this.setAddress(jsonObject.getString("address"));
			this.setGps(jsonObject.getString("gps"));
			this.setPhone(jsonObject.getString("phone"));
			this.setAccount(jsonObject.getString("account"));
			this.setMenu_table(jsonObject.getString("menu_table"));
			this.setMenu_trade(jsonObject.getString("menu_trade"));
			this.setTrade(jsonObject.getInt("trade"));
			this.setActivty(jsonObject.getInt("activity"));
			this.setIntroduction(jsonObject.getString("introduction"));
			this.setRecommendation(jsonObject.getString("recommendation"));
			this.setAssessment(jsonObject.getInt("assessment"));
			this.setTurnover(jsonObject.getDouble("turnvoer"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	@Override
	public String toJSONString() {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("username", getUsername());
			jsonObject.put("password", getPassword());
			jsonObject.put("role", getRole());
			jsonObject.put("address", getAddress());
			jsonObject.put("regiterDate", getRegiterDate());
			jsonObject.put("gps", getGps());
			jsonObject.put("phone", getPhone());
			jsonObject.put("account", getAccount());
			jsonObject.put("menu_trade", getMenu_trade());
			jsonObject.put("menu_table", getMenu_table());
			jsonObject.put("trade", getTrade());
			jsonObject.put("turnover", getTurnover());
			jsonObject.put("activity", getActivty());
			jsonObject.put("introduction", getIntroduction());
			jsonObject.put("recommendation", getRecommendation());
			jsonObject.put("assessment", getAssessment());
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonObject.toString();
	}

}

package wizard.threeperson.entity;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class DelivererUser extends AbsUser {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date regiterDate = new Date(0, 0, 0, 0, 0);
	private String address = "0";
	private String gps = "0";
	private String phone = "0";
	private String account = "0";
	private String destination_scale = "0";
	private String source_scale = "0";
	private int trade;
	private double turnover;
	private int activty;

	public Date getRegiterDate() {
		return regiterDate;
	}

	public void setRegiterDate(Date regiterDate) {
		this.regiterDate = regiterDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGps() {
		return gps;
	}

	public void setGps(String gps) {
		this.gps = gps;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getDestination_scale() {
		return destination_scale;
	}

	public void setDestination_scale(String destination_scale) {
		this.destination_scale = destination_scale;
	}

	public String getSource_scale() {
		return source_scale;
	}

	public void setSource_scale(String source_scale) {
		this.source_scale = source_scale;
	}

	public int getTrade() {
		return trade;
	}

	public void setTrade(int trade) {
		this.trade = trade;
	}

	public double getTurnover() {
		return turnover;
	}

	public void setTurnover(double turnover) {
		this.turnover = turnover;
	}

	public int getActivty() {
		return activty;
	}

	public void setActivty(int activty) {
		this.activty = activty;
	}

	public int getAssessment() {
		return assessment;
	}

	public void setAssessment(int assessment) {
		this.assessment = assessment;
	}

	private int assessment;

	public DelivererUser(String username, String password) {
		super(username, password, "deliverer");
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
			this.setDestination_scale(jsonObject.getString("destination_scale"));
			this.setSource_scale(jsonObject.getString("source_scale"));
			this.setTrade(jsonObject.getInt("trade"));
			this.setActivty(jsonObject.getInt("activity"));
			this.setTurnover(jsonObject.getDouble("turnover"));
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
			jsonObject.put("destination_scale", getDestination_scale());
			jsonObject.put("source_scale", getSource_scale());
			jsonObject.put("trade", getTrade());
			jsonObject.put("turnover", getTurnover());
			jsonObject.put("activity", getActivty());
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonObject.toString();
	}
}

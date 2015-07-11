package wizard.threeperson.entity;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class Order implements Serializable{
	private Date book_time;
	private Date achieve_time;
	private String source;
	private String destination;
	private int priority;
	private String status;
	private String menu;
	private double price;
	private double traffic_cost;
	private double total_cost;
	private String restaurant_name;
	private String restaurant_address;
	private String restaurant_gps;
	private String restaurant_phone;
	private String restaurant_account;
	private String guest_name;
	private String guest_address;
	private String guest_gps;
	private String guest_phone;
	private String guest_account;
	private String deliverer_name;
	private String deliverer_gps;
	private String deliverer_phone;
	private String deliverer_account;
	
	/**
	 * 把food对象序列化
	 * @param food
	 * @return
	 */
	public String toJSONString(Order order) {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("book_time", getBook_time());
			jsonObject.put("achieve_time", getAchieve_time());
			jsonObject.put("source", getSource());
			jsonObject.put("destination", getDestination());
			jsonObject.put("priority", getPriority());
			jsonObject.put("status", getStatus());
			jsonObject.put("menu", getMenu());
			jsonObject.put("price", getPrice());
			jsonObject.put("traffic_cost", getTraffic_cost());
			jsonObject.put("total_cost", getTotal_cost());
			jsonObject.put("restaurant_name", getRestaurant_name());
			jsonObject.put("restaurant_address", getRestaurant_address());
			jsonObject.put("restaurant_gps", getRestaurant_gps());
			jsonObject.put("restaurant_phone", getRestaurant_phone());
			jsonObject.put("restaurant_account", getRestaurant_account());
			jsonObject.put("guest_name", getGuest_name());
			jsonObject.put("guest_address", getGuest_address());
			jsonObject.put("guest_gps", getGuest_gps());
			jsonObject.put("guest_phone", getGuest_phone());
			jsonObject.put("guest_account", getGuest_account());
			jsonObject.put("deliverer_name", getDeliverer_name());
			jsonObject.put("deliverer_gps", getDeliverer_gps());
			jsonObject.put("deliverer_phone", getDeliverer_phone());
			jsonObject.put("deliverer_account", getDeliverer_account());

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonObject.toString();
	}

	/**
	 * 反序列化
	 * @param jsonString
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public Order fromJSONString(String jsonString) {
		try {
			JSONObject jsonObject = new JSONObject(jsonString);
			this.setBook_time(new Date(jsonObject.getString("book_time")));
			this.setAchieve_time(new Date(jsonObject.getString("achieve_time")));
			this.setSource(jsonObject.getString("source"));
			this.setDestination(jsonObject.getString("destination"));
			this.setPriority(jsonObject.getInt("priority"));
			this.setStatus(jsonObject.getString("status"));
			this.setMenu(jsonObject.getString("menu"));
			this.setPrice(jsonObject.getDouble("price"));
			this.setTraffic_cost(jsonObject.getDouble("traffic_cost"));
			this.setTotal_cost(jsonObject.getDouble("total_cost"));
			this.setRestaurant_name(jsonObject.getString("restaurant_name"));
			this.setRestaurant_address(jsonObject.getString("restaurant_address"));
			this.setRestaurant_gps(jsonObject.getString("restaurant_gps"));
			this.setRestaurant_phone(jsonObject.getString("restaurant_phone"));
			this.setRestaurant_account(jsonObject.getString("restaurant_account"));
			this.setGuest_name(jsonObject.getString("guest_name"));
			this.setGuest_address(jsonObject.getString("guest_address"));
			this.setGuest_gps(jsonObject.getString("guest_gps"));
			this.setGuest_phone(jsonObject.getString("guest_phone"));
			this.setGuest_account(jsonObject.getString("guest_account"));
			this.setDeliverer_name(jsonObject.getString("deliverer_name"));
			this.setDeliverer_gps(jsonObject.getString("deliverer_gps"));
			this.setDeliverer_phone(jsonObject.getString("deliverer_phone"));
			this.setDeliverer_account(jsonObject.getString("deliverer_account"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	public Date getBook_time() {
		return book_time;
	}
	public Date getAchieve_time() {
		return achieve_time;
	}
	public String getSource() {
		return source;
	}
	public String getDestination() {
		return destination;
	}
	public int getPriority() {
		return priority;
	}
	public String getStatus() {
		return status;
	}
	public String getMenu() {
		return menu;
	}
	public double getPrice() {
		return price;
	}
	public double getTraffic_cost() {
		return traffic_cost;
	}
	public double getTotal_cost() {
		return total_cost;
	}
	public String getRestaurant_name() {
		return restaurant_name;
	}
	public String getRestaurant_address() {
		return restaurant_address;
	}
	public String getRestaurant_gps() {
		return restaurant_gps;
	}
	public String getRestaurant_phone() {
		return restaurant_phone;
	}
	public String getRestaurant_account() {
		return restaurant_account;
	}
	public String getGuest_name() {
		return guest_name;
	}
	public String getGuest_address() {
		return guest_address;
	}
	public String getGuest_gps() {
		return guest_gps;
	}
	public String getGuest_phone() {
		return guest_phone;
	}
	public String getGuest_account() {
		return guest_account;
	}
	public String getDeliverer_name() {
		return deliverer_name;
	}
	public String getDeliverer_gps() {
		return deliverer_gps;
	}
	public String getDeliverer_phone() {
		return deliverer_phone;
	}
	public String getDeliverer_account() {
		return deliverer_account;
	}
	public void setBook_time(Date book_time) {
		this.book_time = book_time;
	}
	public void setAchieve_time(Date achieve_time) {
		this.achieve_time = achieve_time;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setTraffic_cost(double traffic_cost) {
		this.traffic_cost = traffic_cost;
	}
	public void setTotal_cost(double total_cost) {
		this.total_cost = total_cost;
	}
	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}
	public void setRestaurant_address(String restaurant_address) {
		this.restaurant_address = restaurant_address;
	}
	public void setRestaurant_gps(String restaurant_gps) {
		this.restaurant_gps = restaurant_gps;
	}
	public void setRestaurant_phone(String restaurant_phone) {
		this.restaurant_phone = restaurant_phone;
	}
	public void setRestaurant_account(String restaurant_account) {
		this.restaurant_account = restaurant_account;
	}
	public void setGuest_name(String guest_name) {
		this.guest_name = guest_name;
	}
	public void setGuest_address(String guest_address) {
		this.guest_address = guest_address;
	}
	public void setGuest_gps(String guest_gps) {
		this.guest_gps = guest_gps;
	}
	public void setGuest_phone(String guest_phone) {
		this.guest_phone = guest_phone;
	}
	public void setGuest_account(String guest_account) {
		this.guest_account = guest_account;
	}
	public void setDeliverer_name(String deliverer_name) {
		this.deliverer_name = deliverer_name;
	}
	public void setDeliverer_gps(String deliverer_gps) {
		this.deliverer_gps = deliverer_gps;
	}
	public void setDeliverer_phone(String deliverer_phone) {
		this.deliverer_phone = deliverer_phone;
	}
	public void setDeliverer_account(String deliverer_account) {
		this.deliverer_account = deliverer_account;
	}
	
}

package wizard.threeperson.entity;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class Food implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1149223385379110632L;
	private String name;
	private String price;
	private String image_URL;
	private double weight;
	private String type;
	private String introduction;
	private String restaurant_name;
	private int selling;
	private int assessment;
	private int recommendation;

	public String toJSONString() {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("name", getName());
			jsonObject.put("price", getPrice());
			jsonObject.put("image_URL", getImage_URL());
			jsonObject.put("weight", getWeight());
			jsonObject.put("type", getType());
			jsonObject.put("introduction", getIntroduction());
			jsonObject.put("restaurant_name", getRestaurant_name());
			jsonObject.put("selling", getSelling());
			jsonObject.put("assessment", getAssessment());
			jsonObject.put("recommendation", getRecommendation());

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonObject.toString();
	}

	public Food fromJSONString(String jsonString) {
		try {
			JSONObject jsonObject = new JSONObject(jsonString);
			this.setAssessment(jsonObject.getInt("assessment"));
			this.setImage_URL(jsonObject.getString("image_URL"));
			this.setIntroduction(jsonObject.getString("introduction"));
			this.setName(jsonObject.getString("name"));
			this.setPrice(jsonObject.getString("price"));
			this.setRecommendation(jsonObject.getInt("recommendation"));
			this.setRestaurant_name(jsonObject.getString("restaurant_name"));
			this.setSelling(jsonObject.getInt("selling"));
			this.setType(jsonObject.getString("type"));
			this.setWeight(jsonObject.getDouble("weight"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}

	public int getAssessment() {
		return assessment;
	}

	public String getImage_URL() {
		return image_URL;
	}

	public String getIntroduction() {
		return introduction;
	}

	public String getName() {
		return name;
	}

	public String getPrice() {
		return price;
	}

	public int getRecommendation() {
		return recommendation;
	}

	public String getRestaurant_name() {
		return restaurant_name;
	}

	public int getSelling() {
		return selling;
	}

	public String getType() {
		return type;
	}

	public double getWeight() {
		return weight;
	}

	public void setAssessment(int assessment) {
		this.assessment = assessment;
	}

	public void setImage_URL(String image_URL) {
		this.image_URL = image_URL;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setRecommendation(int recommendation) {
		this.recommendation = recommendation;
	}

	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}

	public void setSelling(int selling) {
		this.selling = selling;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}

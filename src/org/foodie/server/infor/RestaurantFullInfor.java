package org.foodie.server.infor;

import javax.persistence.Column;

import org.foodie.server.entity.Restaurant;

public class RestaurantFullInfor extends Infor{
	private static final long serialVersionUID = 1L;
	
	private long id;

	private String name;
	
	private String logo;
	
	private String description;
	
	private String type;
	
	private String phone;
	
	private String email;
	
	private String openTimeMorning;
	
	private String openTimeAfternoon;
	
	private Boolean checkin;

	private String password;
	

	public RestaurantFullInfor(){
		
	}
	
	public RestaurantFullInfor(Restaurant restaurant){
		this.id=restaurant.getId();
		this.name=restaurant.getName();
		this.logo=restaurant.getLogo();
		this.description=restaurant.getDescription();
		this.email=restaurant.getEmail();
		this.phone=restaurant.getPhone();
		this.openTimeAfternoon=restaurant.getOpenTimeMorning();
		this.password=restaurant.getPassword();
		this.type=restaurant.getType();
		this.openTimeMorning=restaurant.getOpenTimeMorning();
		this.checkin=restaurant.getCheckin();
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public RestaurantFullInfor(long id){
		this.id=id;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getCheckin() {
		return checkin;
	}

	public void setCheckin(Boolean checkin) {
		this.checkin = checkin;
	}
	
	public String getOpenTimeMorning() {
		return openTimeMorning;
	}

	public void setOpenTimeMorning(String openTimeMorning) {
		this.openTimeMorning = openTimeMorning;
	}

	public String getOpenTimeAfternoon() {
		return openTimeAfternoon;
	}

	public void setOpenTimeAfternoon(String openTimeAfternoon) {
		this.openTimeAfternoon = openTimeAfternoon;
	}
	
}

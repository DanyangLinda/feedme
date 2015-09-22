package org.foodie.server.entity;
/**
 * @author Danyang Li
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="restaurant")
public class Restaurant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
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

	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="logo")
	private String logo;
	
	@Column(name="description")
	private String description;
	
	@Column(name="type")
	private String type;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="openTimeMorning")
	private String openTimeMorning;
	
	@Column(name="openTimeAfternoon")
	private String openTimeAfternoon;

	public Restaurant(){
		
	}
	
	public Restaurant(long id){
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

}

package org.foodie.server.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
//@Entity
//@IdClass(value=DishLogUniKey.class)
//@Table(name="currentavailabledish")
public class DishLogView {
	//@Id
	//@Column(name="dat", nullable=false)
	//private Date dat;
	
	//@Id
	//@Column(name="dishId", nullable=false)
	private long dishId;
	
	//@Column(name="shopId", nullable=false)
	private long shopId;
	
	//@Column(name="available", nullable=false)
	private Boolean available;
	
	//@Column(name="type")
	private String type;
	
	//@Column(name="name")
	private String name;
	
	//@Column(name="description")
	private String description;
	
	//@Column(name="photo")
	private String photo;
		
	//@Column(name="ingredient")
	private String ingredient;
	
	//@Column(name="price")
	private Integer price;
	
	//@Column(name="discount")
	private Integer discount;
	
	//@Column(name="flavor")
	private String flavor;
	
	//@Column(name="sold")
	private Integer sold;

	/*public Date getDat() {
		return dat;
	}*/

	/*public void setDat(Date dat) {
		this.dat = dat;
	}
*/
	public long getDishId() {
		return dishId;
	}

	public void setDishId(long dishId) {
		this.dishId = dishId;
	}

	public long getShopId() {
		return shopId;
	}

	public void setShopId(long restaurantId) {
		this.shopId = restaurantId;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}
}


package org.foodie.server.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(value=DishLogUniKey.class)
@Table(name="dishlog")
public class DishLog {
	@Id
	@Column(name="dat", nullable=false)
	private Date dat;
	
	@Id
	@Column(name="dish_id", nullable=false)
	private long dish_id;
	
	@Column(name="restaurant_id", nullable=false)
	private long restaurant_id;
	
	@Column(name="available", nullable=false)
	private Boolean available;

	public Date getDat() {
		return dat;
	}

	public void setDat(Date dat) {
		this.dat = dat;
	}

	

	public long getDish_id() {
		return dish_id;
	}

	public void setDish_id(long dish_id) {
		this.dish_id = dish_id;
	}

	public long getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(long restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}
}

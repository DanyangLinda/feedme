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
	@Column(name="dishId", nullable=false)
	private long dishId;
	
	@Column(name="restaurantId", nullable=false)
	private long restaurantId;
	
	@Column(name="available", nullable=false)
	private Boolean available;

	public Date getDat() {
		return dat;
	}

	public void setDat(Date dat) {
		this.dat = dat;
	}

	public long getDishId() {
		return dishId;
	}

	public void setDishId(long dishId) {
		this.dishId = dishId;
	}

	public long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}
}

package org.foodie.server.entity;

/**
 * 
 * @author Danyang Li
 *
 */
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

public class DishLogUniKey implements Serializable{
	private static final long serialVersionUID = 1L;
	@Column
	private Date dat;
	@Column
	private long dishId;
	
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
	
	@Override
	public boolean equals(Object o){
		if(o instanceof DishLogUniKey){
			DishLogUniKey pk = (DishLogUniKey) o;
			if(this.dat==pk.dat && this.dishId==pk.dishId){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return super.hashCode();
	}
}


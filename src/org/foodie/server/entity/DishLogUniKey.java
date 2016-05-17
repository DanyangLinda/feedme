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
	private long dish_id;
	
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
	@Override
	public boolean equals(Object o){
		if(o instanceof DishLogUniKey){
			DishLogUniKey pk = (DishLogUniKey) o;
			if(this.dat==pk.dat && this.dish_id==pk.dish_id){
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


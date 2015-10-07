package org.foodie.server.entity;
/**
 * 
 * @author Danyang Li
 *
 */
import java.io.Serializable;
import javax.persistence.Column;

public class ODVUniKey implements Serializable{
	private static final long serialVersionUID = 1L;
	@Column
	private long orderId;
	@Column
	private long dishId;
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getDishId() {
		return dishId;
	}
	public void setDishId(long dishId) {
		this.dishId = dishId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof ODVUniKey){
			ODVUniKey pk = (ODVUniKey) o;
			if(this.orderId==pk.orderId&&this.dishId==pk.dishId){
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

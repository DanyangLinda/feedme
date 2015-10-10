package org.foodie.server.entity;
/**
 * @author Danyang Li
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shoppingCart")
public class ShoppingCart {
	@Id
	@Column(name="userId")
	private long userId;
	@Column(name="items")
	private String items;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}	
}

package org.foodie.server.entity;
import javax.persistence.Column;
/**
 * 
 * @author Danyang Li
 *
 */
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(value=ODVUniKey.class)
@Table(name="orderedDishesView")
public class OrderedDishesView {
	@Id
	@Column(name="orderId")
	private long orderId;
	@Id
	@Column(name="dishId")
	private long dishId;
	@Column(name="amount")
	private Integer amount;
	@Column(name="name")
	private String dish;
	@Column(name="price")
	private Integer price;
	@Column(name="photo")
	private String photo;
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}

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

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getDish() {
		return dish;
	}

	public void setDish(String dish) {
		this.dish = dish;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
}

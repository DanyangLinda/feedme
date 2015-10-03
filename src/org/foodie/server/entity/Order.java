package org.foodie.server.entity;
import javax.persistence.Column;
/**
 * @author Danyang Li
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Entity
//@IdClass(value=OrderUnionPK.class)
@Table(name="order")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="orderId", nullable=false)
	private long orderId;
	@Column(name="userId")
	private long userId;
	@Column(name="shopId")
	private long shopId;
	@Column(name="dishId")
	private long dishId;
	@Column(name="amount")
	private Integer amount;
	@Column(name="status")
	private String status;
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getShopId() {
		return shopId;
	}
	public void setShopId(long shopId) {
		this.shopId = shopId;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}

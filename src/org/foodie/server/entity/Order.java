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
	@Column(name="fee")
	private Integer fee;
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
	public Integer getFee() {
		return fee;
	}
	public void setFee(Integer fee) {
		this.fee = fee;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}

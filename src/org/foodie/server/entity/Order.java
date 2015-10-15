package org.foodie.server.entity;
/**
 * @author Danyang Li
 */
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false)
	private long id;
	@Column(name="userId")
	private long userId;
	@Column(name="restaurantId")
	private long restaurantId;
	@Column(name="deliverId")
	private long deliverId;
	@Column(name="addressId")
	private long addressId;
	@Column(name="totalPrice")
	private Integer totalPrice;
	@Column(name="deliveryFee")
	private Integer deliveryfee;
	@Column(name="paymentStatus")
	private String paymentStatus;
	@Column(name="state")
	private String state;
	@Column(name="creatTime")
	private Date creatTime;
	@Column(name="deliverTime")
	private Date deliverTime;
	@Column(name="finishTime")
	private Date finishTime;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}
	public long getDeliverId() {
		return deliverId;
	}
	public void setDeliverId(long deliverId) {
		this.deliverId = deliverId;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getDeliveryfee() {
		return deliveryfee;
	}
	public void setDeliveryfee(Integer deliveryfee) {
		this.deliveryfee = deliveryfee;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getDeliverTime() {
		return deliverTime;
	}
	public void setDeliverTime(Date deliverTime) {
		this.deliverTime = deliverTime;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public Date getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
}

package org.foodie.server.entity;
/**
 * Danyang Li
 */
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="deliveryTogether")
public class GroupOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="deliveryTogetherId")
	private long id;
	
	@Column(name="CreateUserId")
	private long userId;
	
	@Column(name="restaurantId")
	private long shopId;
	
	@Column(name="deliverId")
	private long deliverId;
	
	@Column(name="status")
	private String status;
	
	@Column(name="paymentStatus")
	private String payStatus;
	
	@Column(name="startTime")
	private Date startTime;
	
	@Column(name="endTime")
	private Date endTime;
	
	@Column(name="deliveriedTime")
	private Date deliveriedTime;
	
	@Column(name="deliveryTime")
	private Date deliveryTime;
	
	@Column(name="deliveryFee")
	private Double deliveryFee;
	
	@Column(name="suburb")
	private String suburb;
	
	@Column(name="street")
	private String street;
	
	@Column(name="building")
	private String building;
	
	@Column(name="GPS")
	private String GPS;
	
	@Column(name="members")
	private Integer members;

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

	public long getShopId() {
		return shopId;
	}

	public void setShopId(long shopId) {
		this.shopId = shopId;
	}

	public long getDeliverId() {
		return deliverId;
	}

	public void setDeliverId(long deliverId) {
		this.deliverId = deliverId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getDeliveriedTime() {
		return deliveriedTime;
	}

	public void setDeliveriedTime(Date deliveriedTime) {
		this.deliveriedTime = deliveriedTime;
	}

	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Double getDeliveryFee() {
		return deliveryFee;
	}

	public void setDeliveryFee(Double deliveryFee) {
		this.deliveryFee = deliveryFee;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getGPS() {
		return GPS;
	}

	public void setGPS(String gPS) {
		GPS = gPS;
	}

	public Integer getMembers() {
		return members;
	}

	public void setMembers(Integer members) {
		this.members = members;
	}
	
}

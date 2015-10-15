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
@Table(name="joinedMember")
public class GroupMember {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="joinId")
	private long id;
	
	@Column(name="deliveryTogetherId")
	private long groupId;
	
	@Column(name="userId")
	private long userId;

	@Column(name="sharedDeliveryFee")
	private Double shareDF;
	
	@Column(name="returnedCredit")
	private Integer returnedCredit;
	
	@Column(name="totalPrice")
	private Integer totalPrice;
	
	@Column(name="paymentStatus")
	private String paymentStatus;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Integer getReturnedCredit() {
		return returnedCredit;
	}

	public void setReturnedCredit(Integer returnedCredit) {
		this.returnedCredit = returnedCredit;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public Double getShareDF() {
		return shareDF;
	}

	public void setShareDF(Double shareDF) {
		this.shareDF = shareDF;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
}

package org.foodie.server.service;

import org.foodie.server.infor.Infor;

public class MemberInfo extends Infor{
	private static final long serialVersionUID = 1L;
	long memberId;
	double sharedFee;
	
	public MemberInfo(){
		
	}
	
	public MemberInfo(final String status, final Integer statusCode){
		super(status, statusCode);
	}
	
	public MemberInfo(final long memberId, final double sharedFee){
		this.memberId=memberId;
		this.sharedFee=sharedFee;
	}
	
	public long getMemberId() {
		return memberId;
	}
	
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

	public double getSharedFee() {
		return sharedFee;
	}

	public void setSharedFee(double sharedFee) {
		this.sharedFee = sharedFee;
	}
	
}

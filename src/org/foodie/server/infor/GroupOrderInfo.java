package org.foodie.server.infor;
/**
 * 
 * @author Danyang Li
 *
 */
public class GroupOrderInfo extends Infor {
	private static final long serialVersionUID = 1L;
	
	private long createrId;
	private long groupOrderId;
	public GroupOrderInfo(){
		
	}
	
	public GroupOrderInfo(final String errorInfo, final Integer statusCode){
		super(errorInfo,statusCode);
	}
	
	public GroupOrderInfo(final long createrId, final long groupOrderId){
		this.createrId=createrId;
		this.groupOrderId=groupOrderId;
	}

	public long getCreaterId() {
		return createrId;
	}

	public void setCreaterId(long joinId) {
		this.createrId = joinId;
	}

	public long getGroupOrderId() {
		return groupOrderId;
	}

	public void setGroupOrderId(long groupOrderId) {
		this.groupOrderId = groupOrderId;
	}
	
}

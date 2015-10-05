package org.foodie.server.infor;
/**
 * @author Danyang Li
 */
public class RestaurantInfo extends Infor{
	private static final long serialVersionUID = 1L;
	private long id;
	
	public RestaurantInfo(){
		
	}
	
	public RestaurantInfo(final long id){
		this.setId(id);
	}
	
	public RestaurantInfo(String status, Integer statusCode){
		super(status,statusCode);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}

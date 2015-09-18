package org.foodie.server.infor;
/**
 * 
 * @author Danyang Li
 *
 */
public class RestaurantId {
	private long id;
	private String name;
	
	public RestaurantId(){
		
	}
	
	public RestaurantId(final long id, final String name){
		this.id=id;
		this.name=name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

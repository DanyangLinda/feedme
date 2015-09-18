package org.foodie.server.infor;

import java.util.ArrayList;
import java.util.List;
import org.foodie.server.entity.Restaurant;

/**
 * @author Danyang Li
 *
 */
public class RestaurantListInfo extends Infor{
	private static final long serialVersionUID = 1L;
	private List<RestaurantId> rList;
	
	public RestaurantListInfo(){
		rList=new ArrayList<RestaurantId>();
	}
	
	public RestaurantListInfo(List<Restaurant> restaurants){
		rList=new ArrayList<RestaurantId>();
		for(Restaurant o: restaurants){
			rList.add(new RestaurantId(o.getId(),o.getName()));
		}
	}
	
	public RestaurantListInfo(final String statusInfo, final Integer statusCode){
		super(statusInfo,statusCode);
	}
	
	public List<RestaurantId> getrList() {
		return rList;
	}

	public void setrList(List<RestaurantId> rList) {
		this.rList = rList;
	}
	
}

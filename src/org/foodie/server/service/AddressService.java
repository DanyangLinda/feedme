package org.foodie.server.service;
import java.util.List;

import org.foodie.server.entity.Building;
import org.foodie.server.entity.Street;
import org.foodie.server.entity.Suburb;
/**
 * @author Danyang Li
 */
import org.springframework.stereotype.Service;

@Service
public interface AddressService {
	void addAddress(String state, String suburb, String streat, String building);
	List<Suburb> querySuburbs(long id);
	List<Street> queryStreats(long id);
	List<Building> queryBuildings(long id);

}

package org.foodie.server.service;
import java.util.List;

import org.foodie.server.dao.BuildingDao;
/**
 * @author Danyang Li
 */
import org.foodie.server.dao.StateDao;
import org.foodie.server.dao.StreatDao;
import org.foodie.server.dao.SuburbDao;
import org.foodie.server.entity.Building;
import org.foodie.server.entity.State;
import org.foodie.server.entity.Street;
import org.foodie.server.entity.Suburb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressServiceImp implements AddressService{
	@Autowired
	private StateDao stateDao;
	@Autowired
	private SuburbDao suburbDao;
	@Autowired 
	private StreatDao streatDao;
	@Autowired
	private BuildingDao buildingDao;
	
	@Override
	public void addAddress(String state, String suburb, String streat, String building) {
		State stt=stateDao.findOneByName(state);		
	}
	
	@Override
	public List<Suburb> querySuburbs(long id) {		
		return suburbDao.findByStateId(id);
	}
	
	@Override
	public List<Street> queryStreats(long id) {	
		return streatDao.findBySuburbId(id);
	}
	@Override
	public List<Building> queryBuildings(long id) {
		return buildingDao.findByStreatId(id);
	}

}

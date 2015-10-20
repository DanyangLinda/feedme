package org.foodie.server.controller;

import java.util.List;

import org.foodie.server.entity.Building;
import org.foodie.server.entity.Street;
import org.foodie.server.entity.Suburb;
import org.foodie.server.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired 
	private AddressService addressService;
	
	@RequestMapping("querySuburb")
	@ResponseBody
	public List<Suburb> querySuburb(@RequestParam("stateId") long stateId){
		List<Suburb> suburbs=null;
		try{
			suburbs=addressService.querySuburbs(stateId);
		}catch (Exception e){
			System.out.println(e.toString());
			return null;
		}
		return suburbs;
	}
	
	@RequestMapping("queryStreat")
	@ResponseBody
	public List<Street> queryStreat(@RequestParam("suburbId")long suburbId){
		List<Street> streats=null;
		try{
			streats=addressService.queryStreats(suburbId);
		}catch(Exception e){
			System.out.println(e.toString());
			return null;
		}
		return streats;
	}
	
	public List<Building> queryBuilding(@RequestParam("streatId")long streateId){
		List<Building> buildings=null;
		try{
			buildings=addressService.queryBuildings(streateId);
		}catch(Exception e){
			System.out.println(e.toString());
			return null;
		}
		return buildings;
	}

}

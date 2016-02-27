package org.foodie.server.controller;
import org.apache.log4j.Logger;
import org.foodie.server.entity.User;
import org.foodie.server.infor.StatusCode;
import org.foodie.server.infor.Infor;
import org.foodie.server.infor.UserInfo;
import org.foodie.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author Danyang Li
 */
@RestController
@CrossOrigin()
@RequestMapping("/users")
public class UserController {
	
  @Autowired
  private UserService userService;
  
  private static Logger log = Logger.getLogger(UserController.class.getName());
  
  @RequestMapping("/checkEmail")
  @ResponseBody
  public Infor checkEmail(@RequestParam("email")String email){
	  Infor result=new Infor();
	  try{
		  User user = userService.query(email.trim());
		  if (user==null){
			  result.setStatusInfo("Y");
			  result.setStatusCode(StatusCode.NORMAL);
			  return result;
		  }else{
			  result.setStatusInfo("N");
			  result.setStatusCode(StatusCode.NORMAL);
			  return result;
		  }
	  }catch(Exception e){
		  result.setStatusInfo(e.toString());
		  result.setStatusCode(StatusCode.PERSIST_ERROR);
		  return result;
	  }
  }
  
  @RequestMapping(value="/register", method=RequestMethod.POST)
  @ResponseBody
  public Infor create(@RequestBody User newUser) {  	
	  try {
		  userService.create(newUser);
	  }
	  catch (Exception ex) {
		  return new Infor(ex.toString(),StatusCode.PERSIST_ERROR);
	  }
	  return new Infor("Success",StatusCode.NORMAL);
  }
  
  @RequestMapping(value="/login")
  @ResponseBody
  public UserInfo getUser(@RequestParam("email")String email, @RequestParam("pwd")String pwd){
	  try{
		  final UserInfo result;
		  final User user=userService.query(email.trim());
		  if(user!=null&&user.getPassword().equals(pwd)){
			  result=new UserInfo(user);
			  result.setStatusInfo("Y");
			  return result;
		  }
		  else{
			 result=new UserInfo();
			 result.setStatusInfo("N");
			 return result;
		  }
	  }catch(Exception e){
		  return new UserInfo(e.toString(),StatusCode.PERSIST_ERROR);
	  }
  }
  
  @RequestMapping("/delete")
  @ResponseBody
  public String delete(/*@RequestParam("id")long id*/) {
    try {
    	long id = 6;
      User user = new User(id);
      userService.remove(user);
    }
    catch (Exception ex) {
      return "Error deleting the user:" + ex.toString();
    }
    return "User succesfully deleted!";
  }
  
  /**
   * /get-by-email  --> Return the id for the user having the passed email.
   * 
   * @param email The email to search in the database.
   * @return The user id or a message error if the user is not found.
   */

  @RequestMapping("getByEmail")
  @ResponseBody
  public User getByEmail(/*@RequestParam("email")String email*/) {
	  String email="u5526912@anu.edu.au";
	  log.info(email);
    try {
    	User user = userService.query(email);
    	return user;
    }
    catch (Exception ex) {
      log.error(ex);
      return null;
    }
  }
  
  @RequestMapping("/update")
  @ResponseBody
  public String updateUser(@RequestParam("user")User updatedUser) {
    try {
    	userService.update(updatedUser);
    }
    catch (Exception ex) {
      return "Error updating the user: " + ex.toString();
    }
    return "User succesfully updated!";
  }

}
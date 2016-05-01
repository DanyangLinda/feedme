package org.foodie.server.entity;
/**
 * @author Danyang Li
 */
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents an User for this web application.
 */
@Entity
@Table(name = "user")
public class User {

  @Id
  @Column(name="id", nullable=false,unique=true)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  
  @Column(name="firstname", nullable=false)
  private String firstname;
  
  @Column(name="lastname", nullable=false)
  private String lastname;
  
  @Column(name="birthday")
  private Date birthday;
  
  @Column(name="password")
  private String password;
  
  @Column(name="registerTime")
  private Date register_time;
  
  @Column(name="preferedLanguage")
  private String preferedLanguage;
  
  @Column(name="photo")
  private String photo;
  
  @Column(name="phoneNumber")
  private String phoneNumber;
  
  @Column(name="email", nullable=false)
  private String email;

  @Column(name="title")
  private String title;
  
  @Column(name="machineCode")
  private String machineCode;

  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  public User(){
	  
  }
  
  public User(long id){
	  this.id=id;
  }
  
  public User(String email, String password, String firstname, String lastname, String title) {
    this.email = email;
    this.firstname = firstname;
    this.lastname = lastname;
    this.password = password;
    this.title = title;
  }
  
  
  public String getMachineCode() {
	return machineCode;
}

public void setMachineCode(String machineCode) {
	this.machineCode = machineCode;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public Date getBirthday() {
	return birthday;
}

public void setBirthday(Date birthday) {
	this.birthday = birthday;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public Date getRegister_time() {
	return register_time;
}

public void setRegister_time(Date register_time) {
	this.register_time = register_time;
}

public String getPreferedLanguage() {
	return preferedLanguage;
}

public void setPreferedLanguage(String prefer_language) {
	this.preferedLanguage = prefer_language;
}

public String getPhoto() {
	return photo;
}

public void setPhoto(String photo) {
	this.photo = photo;
}

public String getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}

  public long getId() {
    return id;
  }

  public void setId(long value) {
    this.id = value;
  }

  public String getEmail() {
    return email;
  }
  
  public void setEmail(String value) {
    this.email = value;
  }  
} // class User

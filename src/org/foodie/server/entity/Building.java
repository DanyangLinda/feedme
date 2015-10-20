package org.foodie.server.entity;
/**
 * @author Danyang Li
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="building")
public class Building {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="streetId")
	private long streatId;
	
	@Column(name="number")
	private String number;
	
	@Column(name="name")
	private String name;
	
	@Column(name="shortName")
	private String shortName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getStreatId() {
		return streatId;
	}

	public void setStreatId(long streatId) {
		this.streatId = streatId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	

}

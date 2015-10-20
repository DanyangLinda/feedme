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
@Table(name="street")
public class Street {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private long id;
	
	@Column(name="suburbId")
	private long suburbId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="shortName")
	private String shortName;
}

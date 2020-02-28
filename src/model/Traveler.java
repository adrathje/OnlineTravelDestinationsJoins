package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "traveler")
public class Traveler {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRAVELER_ID")
	private int id;
	@Column(name = "TRAVELER_NAME")
	private String travelerName;
	
	/**
	 * default no argument constructor
	 */
	public Traveler() {
	}
	
	/**
	 * @param travelerName
	 */
	public Traveler(String travelerName) {
		this.travelerName = travelerName;
	}
	
	/**
	 * @param id
	 * @param travelerName
	 */
	public Traveler(int id, String travelerName) {
		this.id = id;
		this.travelerName = travelerName;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the travelerName
	 */
	public String getTravelerName() {
		return travelerName;
	}

	/**
	 * @param travelerName the travelerName to set
	 */
	public void setTravelerName(String travelerName) {
		this.travelerName = travelerName;
	}

	@Override
	public String toString() {
		return "Traveler [id=" + id + ", travelerName=" + travelerName + "]";
	}
	
	
}

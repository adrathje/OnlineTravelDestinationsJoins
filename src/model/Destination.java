package model;

/**
 * Name: Austin Rathje 
 * Date: 2/19/2020
 * Operating System: Windows 10
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class Destination {
	// Attributes.
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	@Column(name="ID")
	private int id;
	@Column(name="COUNTRY")
	private String country;
	@Column(name="CITY")
	private String city;
	

	/**
	 * default constructor that takes no arguments
	 */
	public Destination() {
		super();
	}

	/**
	 * non-default constructor that takes country and city arguments
	 * 
	 * @param country
	 * @param city
	 */
	public Destination(String country, String city) {
		super();
		this.country = country;
		this.city = city;
	}

	/**
	 * displays destination details
	 * @return
	 */
	public String returnDestinationDetails() {
		return country + ": " + city;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
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

}

package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "list_info")
public class ListInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LIST_ID")
	private int id;
	@Column(name = "LIST_NAME")
	private String listName;
	@ManyToOne
	@JoinColumn(name = "TRAVELER_ID")
	private Traveler traveler;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "DESTINATIONS_IN_LIST", joinColumns = {
			@JoinColumn(name = "LIST_ID", referencedColumnName = "LIST_ID") }, inverseJoinColumns = {
					@JoinColumn(name = "ITEM_ID", referencedColumnName = "ID", unique = true) })
	private List<Destination> listOfItems;
	/**
	 * 
	 */
	public ListInfo() {
	}
	/**
	 * @param id
	 * @param listName
	 * @param traveler
	 * @param listOfItems
	 */
	public ListInfo(int id, String listName, Traveler traveler, List<Destination> listOfItems) {
		this.id = id;
		this.listName = listName;
		this.traveler = traveler;
		this.listOfItems = listOfItems;
	}
	/**
	 * @param listName
	 * @param traveler
	 * @param listOfItems
	 */
	public ListInfo(String listName, Traveler traveler, List<Destination> listOfItems) {
		this.listName = listName;
		this.traveler = traveler;
		this.listOfItems = listOfItems;
	}
	/**
	 * @param listName
	 * @param traveler
	 */
	public ListInfo(String listName, Traveler traveler) {
		this.listName = listName;
		this.traveler = traveler;
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
	 * @return the listName
	 */
	public String getListName() {
		return listName;
	}
	/**
	 * @param listName the listName to set
	 */
	public void setListName(String listName) {
		this.listName = listName;
	}
	/**
	 * @return the traveler
	 */
	public Traveler getTraveler() {
		return traveler;
	}
	/**
	 * @param traveler the traveler to set
	 */
	public void setTraveler(Traveler traveler) {
		this.traveler = traveler;
	}
	/**
	 * @return the listOfItems
	 */
	public List<Destination> getListOfItems() {
		return listOfItems;
	}
	/**
	 * @param listOfItems the listOfItems to set
	 */
	public void setListOfItems(List<Destination> listOfItems) {
		this.listOfItems = listOfItems;
	}
	@Override
	public String toString() {
		return "ListInfo [id=" + id + ", listName=" + listName + ", traveler=" + traveler + ", listOfItems="
				+ listOfItems + "]";
	}
	
	
}

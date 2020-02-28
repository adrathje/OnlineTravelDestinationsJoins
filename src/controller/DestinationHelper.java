package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Destination;

/**
 * Name: Austin Rathje
 * Date: 2/27/2020
 * Operating System: Windows 10
 */

public class DestinationHelper {
	// open the EntityManagerFactory connection
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleDestinationsList");

	/**
	 * inserts a destination
	 * 
	 * @param dest
	 */
	public void insertDestination(Destination dest) {
		EntityManager entityManager = emfactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(dest);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	/**
	 * displays all destinations
	 * 
	 * @return allDestinations
	 */
	public List<Destination> displayAllDestinations() {
		EntityManager entityManager = emfactory.createEntityManager();
		List<Destination> allDestinations = entityManager.createQuery("SELECT i FROM Destination i").getResultList();
		return allDestinations;
	}

	/**
	 * takes in a destination to delete and remove it
	 * 
	 * @param toDelete
	 */
	public void deleteDestination(Destination toDelete) {
		EntityManager entityManager = emfactory.createEntityManager();
		entityManager.getTransaction().begin();
		TypedQuery<Destination> typedQuery = entityManager.createQuery(
				"select li from Destination li where li.country = :selectedCountry and li.city = :selectedCity",
				Destination.class);

		// substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedCountry", toDelete.getCountry());
		typedQuery.setParameter("selectedCity", toDelete.getCity());

		// set max result to one
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		Destination result = typedQuery.getSingleResult();

		// remove it
		entityManager.remove(result);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	/**
	 * close the EntityManagerFactory connection
	 */
	public void cleanUp() {
		emfactory.close();
	}

	/**
	 * updates an existing destination
	 * 
	 * @param toEdit
	 */
	public void updateDestination(Destination toEdit) {
		EntityManager entityManager = emfactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(toEdit);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	/**
	 * searches for a city based on a given country, if found return it
	 * 
	 * @param country
	 * @return foundCities
	 */
	public List<Destination> searchForCityByCountry(String country) {
		EntityManager entityManager = emfactory.createEntityManager();
		entityManager.getTransaction().begin();
		TypedQuery<Destination> typedQuery = entityManager
				.createQuery("select li from Destination li where li.country = :selectedCountry", Destination.class);
		typedQuery.setParameter("selectedCountry", country);
		List<Destination> foundCities = typedQuery.getResultList();
		entityManager.close();
		return foundCities;
	}

	/**
	 * searches for a city based on a given city name, if found return it
	 * 
	 * @param city
	 * @return foundCities
	 */
	public List<Destination> searchForCityByCity(String city) {
		EntityManager entityManager = emfactory.createEntityManager();
		entityManager.getTransaction().begin();
		TypedQuery<Destination> typedQuery = entityManager
				.createQuery("select li from Destination li where li.city = :selectedCity", Destination.class);
		typedQuery.setParameter("selectedCity", city);
		List<Destination> foundCities = typedQuery.getResultList();
		entityManager.close();
		return foundCities;
	}

	/**
	 * searches for a city based on a given Id number, if found return it
	 * 
	 * @param idNum
	 * @return foundCity
	 */
	public Destination searchForCityById(int idNum) {
		EntityManager entityManager = emfactory.createEntityManager();
		entityManager.getTransaction().begin();
		Destination foundCity = entityManager.find(Destination.class, idNum);
		entityManager.close();
		return foundCity;
	}
}

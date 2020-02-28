package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Traveler;


public class TravelerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleDestinationsList");

	public void insertShopper(Traveler traveler) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(traveler);
		em.getTransaction().commit();
		em.close();
	}

	public List<Traveler> showAllTravelers() {
		EntityManager em = emfactory.createEntityManager();
		List<Traveler> allTravelers = em.createQuery("SELECT t FROM Traveler t").getResultList();
		return allTravelers;
	}

	public Traveler searchForTravelerByName(String travelerName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Traveler> typedQuery = em.createQuery("select t from Traveler t where t.travelerName = :selectedName", Traveler.class);
		typedQuery.setParameter("selectedName", travelerName);
		
		// set max result to one
		typedQuery.setMaxResults(1);

		Traveler found = typedQuery.getSingleResult();
		em.close();
		
		return found;
	}
}

package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListInfo;

public class ListInfoHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleDestinationsList");

	public void insertNewListDetails(ListInfo s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}

	public List<ListInfo> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<ListInfo> allDetails = em.createQuery("SELECT d FROM ListInfo d").getResultList();
		return allDetails;
	}

	public ListInfo searchForListById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListInfo found = em.find(ListInfo.class, tempId);
		em.close();
		return found;
	}

	public void deleteItem(ListInfo toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListInfo> typedQuery = em.createQuery("select d from ListInfo d where d.id = :selectedid", ListInfo.class);
		typedQuery.setParameter("selectedid", toDelete.getId());

		// set max result to one, get result, and save it
		typedQuery.setMaxResults(1);
		ListInfo result = typedQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public void updateList(ListInfo toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}

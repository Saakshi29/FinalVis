package com.visa.training.jpa.dal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.visa.training.jpa.domain.Account;

public class JpaAccountDAO {

	public Account save(Account p) {
		EntityManagerFactory emf = JpaUtil.getEmf();
		EntityManager em = emf.createEntityManager();

		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.persist(p);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();

		}
		return p;
	}

	public Account findById(int id) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		try {
			Account p = em.find(Account.class, id);
			return p;
		} finally {
			em.close();
		}

	}

	public void remove(int id) {// delete
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			Account p = em.find(Account.class, id);
			if (p != null)
				em.remove(p);

			tx.commit();

		} finally {
			em.close();
		}

	}

	public void update(Account detached) { // update
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			// int id=updated.getId();
			em.merge(detached);
			tx.commit();

		} finally {
			em.close();
		}

	}

}

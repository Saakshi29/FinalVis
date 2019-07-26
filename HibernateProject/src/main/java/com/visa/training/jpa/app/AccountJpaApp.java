package com.visa.training.jpa.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.visa.training.jpa.dal.JpaAccountDAO;
import com.visa.training.jpa.dal.JpaProductDAO;
import com.visa.training.jpa.dal.JpaUtil;
import com.visa.training.jpa.domain.Account;
import com.visa.training.jpa.domain.CurrentAccount;
import com.visa.training.jpa.domain.SavingsAccount;

public class AccountJpaApp {

	public static void main(String[] args) {

		EntityManager em = JpaUtil.getEmf().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		SavingsAccount sa = new SavingsAccount(10000);
		CurrentAccount ca = new CurrentAccount(100000, 1000);
		em.persist(sa);
		em.persist(ca);
		tx.commit();

		Account unknown = em.find(Account.class, sa.getId());
		System.out.println(unknown.getClass().getName());
		System.exit(0);

		/*
		 * JpaAccountDAO dao = new JpaAccountDAO(); SavingsAccount test = new
		 * SavingsAccount(9000); Account saved = dao.save(test);
		 * System.out.println(saved); Account f = dao.findById(saved.getId());
		 * System.out.println(f); System.out.println(f == saved);
		 */
		// test update
		// f.setPrice(f.getPrice() + 10);
		// dao.update(f);

		// Product updated = dao.findById(f.getId());
		// System.out.println(updated);

		// System.out.println(f);
		// dao.remove(7);
		System.exit(0);

	}

}

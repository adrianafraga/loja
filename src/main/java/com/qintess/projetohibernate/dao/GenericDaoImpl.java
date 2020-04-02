package com.qintess.projetohibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qintess.projetohibernate.model.EntidadeBase;
import com.qintess.projetohibernate.util.HibernateUtil;

public class GenericDaoImpl<T extends EntidadeBase> implements GenericDao<T> {

	@Override
	public void salvar(T item) {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			System.out.println(item);
			session.save(item);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public T buscarPorId(Class<T> clazz, Object id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			return session.find(clazz, id);
		} finally {
			session.close();
		}
	}

	@Override
	public List<T> buscarTodos(Class<T> clazz) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			return session.createQuery("select c from " + clazz.getSimpleName() + " c order by id", clazz)
					.getResultList();
		} finally {
			session.close();
		}

	}

	@Override
	public void deletar(Class<T> clazz, Object id) {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			session.remove(session.find(clazz, id));
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
}

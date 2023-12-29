package com.goit.generic_dao;

import com.goit.hibernate_util.DatabaseUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;

public class Dao<T> {
    private final SessionFactory sessionFactory = DatabaseUtil.getInstance().getSessionFactory();
    private final Class<T> entityClass;
    public Dao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    public void save(T entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(entity);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public T findById(Serializable id) {
        T entity = null;
        try (Session session = sessionFactory.openSession()) {
            entity = session.get(entityClass, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }
    public void update(T entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(entity);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delete(T entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(entity);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

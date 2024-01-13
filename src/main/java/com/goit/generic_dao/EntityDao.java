package com.goit.generic_dao;

import com.goit.hibernate_util.DatabaseUtil;

import com.goit.table_entities.clients.Client;
import com.goit.table_entities.tickets.Ticket;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public class EntityDao<T> {
    private final SessionFactory sessionFactory = DatabaseUtil.getInstance().getSessionFactory();
    private final Class<T> entityClass;
    public EntityDao(Class<T> entityClass) {
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
            Transaction tx = session.beginTransaction();
            entity = session.get(entityClass, id);
            if (entity instanceof Client) {
                setTickets((Client) entity);
            }
            Hibernate.initialize(entity);
            tx.commit();
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
    public void setTickets(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("FROM Ticket WHERE id = :id");
            query.setParameter("id", client.getId());
            client.setTicket(query.getResultList());
            tx.commit();
        }
    }
}

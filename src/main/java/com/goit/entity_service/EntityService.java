package com.goit.entity_service;

import com.goit.generic_dao.EntityDao;

import java.io.Serializable;

public class EntityService<T> {
    private EntityDao<T> entityDao;
    public EntityService(Class<T> entityClass) {
        entityDao = new EntityDao<>(entityClass);
    }
    public void save(T entity) {
        entityDao.save(entity);
    }
    public T findById(Serializable id) {
        return entityDao.findById(id);
    }
    public void update(T entity) {
        entityDao.update(entity);
    }
    public void delete(T entity) {
        entityDao.delete(entity);
    }
}
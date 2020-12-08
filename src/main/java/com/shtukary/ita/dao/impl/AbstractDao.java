package com.shtukary.ita.dao.impl;

import com.shtukary.ita.dao.BaseDao;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

@Repository
public abstract class AbstractDao<T, PK extends Serializable> implements BaseDao<T, PK> {

    private final Class<T> clazz;

    @SuppressWarnings("unchecked")
    public AbstractDao() {
        clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public Optional<T> findById(PK pk) {
        if (pk == null) return Optional.empty();
        T entity = sessionFactory.getCurrentSession().get(clazz, pk);
        return Optional.ofNullable(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T save(T object) {
        sessionFactory.getCurrentSession().save(object);
        return object;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T update(T object) {
        sessionFactory.getCurrentSession().merge(object);
        return object;
    }

    @Override
    public boolean existsById(PK pk) {
        return findById(pk).isPresent();
    }

    @Override
    public void deleteById(PK pk) {
        T entity = sessionFactory.getCurrentSession().get(clazz, pk);
        if (entity != null) {
            delete(entity);
        }
    }

    @Override
    public void delete(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> findWithPagination(int first, int count) {
        return (List<T>) sessionFactory.getCurrentSession().createQuery("from " + clazz.getName())
                .setFirstResult(first)
                .setMaxResults(count)
                .list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return (List<T>) sessionFactory.getCurrentSession().createQuery("from " + clazz.getName()).list();
    }

    protected Query createNamedQuery(String query) {
        return sessionFactory.getCurrentSession().createNamedQuery(query);
    }

}

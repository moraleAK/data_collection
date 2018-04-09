package com.el.dc.api.database.dao;

import com.el.wc.payment.commons.ErrorCode;
import com.el.wc.payment.commons.exception.DaoException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * User: Rolandz
 * Date: 5/27/16
 * Time: 3:40 PM
 */
public abstract class GenericDaoImpl<T, KeyType> implements GenericDao<T, KeyType> {
    @PersistenceContext
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public T load(final KeyType id) {
        return em.find(getDomainClass(), id);
    }

    protected abstract Class<T> getDomainClass();

    @Override
    public void persist(final T t) {
        em.persist(t);
    }

    @Override
    public T merge(final T t) {
        return em.merge(t);
    }

    @Override
    public void remove(T t) {
        em.remove(t);
    }

    @Override
    public TypedQuery<T> query(final String ql, final Object... args) {
        TypedQuery<T> q = em.createQuery(ql, getDomainClass());

        for (int n = 1; n <= args.length; n++) {
            q.setParameter(n, args[n - 1]);
        }
        return q;
    }

    public <E> TypedQuery<E> queryGeneral(final String ql, final Class<E> clazz, final Object... args) {
        TypedQuery<E> q = em.createQuery(ql, clazz);

        for (int n = 1; n <= args.length; n++) {
            q.setParameter(n, args[n - 1]);
        }
        return q;
    }

    @Override
    public TypedQuery<T> query(final String ql) {
        return em.createQuery(ql, getDomainClass());
    }

    @Override
    public List<T> getResultList(TypedQuery<T> q, int errorCode) {
        try {
            return q.getResultList();
        } catch (Throwable t) {
            throw new DaoException(t, ErrorCode.EX_DAO, t.getMessage());
        }
    }
}
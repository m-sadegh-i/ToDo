package ir.maktab.todo.base.repository.impl;

import ir.maktab.todo.base.domain.BaseEntity;
import ir.maktab.todo.util.HibernateUtil;
import ir.maktab.todo.base.repository.BaseRepository;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public abstract class BaseRepositoryImpl<E extends BaseEntity<ID>, ID> implements BaseRepository<E, ID> {

    protected static final EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityManagerFactory();

    protected static EntityManager entityManager = entityManagerFactory.createEntityManager();

    protected static EntityTransaction transaction = entityManager.getTransaction();

    public BaseRepositoryImpl() {
    }
}

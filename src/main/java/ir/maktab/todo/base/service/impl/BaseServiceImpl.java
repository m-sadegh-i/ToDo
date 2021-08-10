package ir.maktab.todo.base.service.impl;

import ir.maktab.todo.base.domain.BaseEntity;
import ir.maktab.todo.base.repository.BaseRepository;
import ir.maktab.todo.base.service.BaseService;
import ir.maktab.todo.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class BaseServiceImpl<E extends BaseEntity<ID>, ID, R extends BaseRepository<E, ID>>
        implements BaseService<E, ID> {

    protected static final EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityManagerFactory();

    protected static EntityManager entityManager = entityManagerFactory.createEntityManager();

    protected static EntityTransaction transaction = entityManager.getTransaction();

    protected final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public E save(E e) {
        return repository.save(e);
    }

    @Override
    public E update(E e) {
        return repository.update(e);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public List<E> findAllById(ID[] ids) {
        return repository.findAllById(ids);
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public E findById(ID id) {
        return repository.findById(id);
    }
}
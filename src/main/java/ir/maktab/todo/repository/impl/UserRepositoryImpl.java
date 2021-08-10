package ir.maktab.todo.repository.impl;

import ir.maktab.todo.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.todo.domain.User;
import ir.maktab.todo.repository.UserRepository;

import java.util.List;

public class UserRepositoryImpl extends BaseRepositoryImpl<User, Long> implements UserRepository {

    @Override
    public User save(User user) {

        transaction.begin();

        entityManager.persist(user);

        transaction.commit();

        return user;
    }

    @Override
    public User update(User user) {

        transaction.begin();

        entityManager.merge(user);

        transaction.commit();

        return user;
    }

    @Override
    public List<User> findAll() {

        return entityManager.createQuery("from User ", User.class).getResultList();
    }

    public User findByUsername(String username) {

        List<User> users = entityManager.createQuery("from User u where" +
                " u.userName = :username ").setParameter("username", username).getResultList();

        return users.get(0);
    }

    @Override
    public List<User> findAllById(Long[] longs) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public User findById(Long id) {

        return entityManager.find(User.class, id);
    }

    @Override
    public Boolean existsById(Long aLong) {
        return null;
    }
}

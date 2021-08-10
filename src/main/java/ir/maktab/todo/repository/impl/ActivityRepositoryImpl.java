package ir.maktab.todo.repository.impl;

import ir.maktab.todo.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.todo.domain.Activity;
import ir.maktab.todo.repository.ActivityRepository;

import java.util.List;

public class ActivityRepositoryImpl extends BaseRepositoryImpl<Activity, Long> implements ActivityRepository {

    public ActivityRepositoryImpl() {
    }

    @Override
    public Activity save(Activity activity) {

        transaction.begin();

        entityManager.persist(activity);

        transaction.commit();

        return activity;
    }

    @Override
    public Activity update(Activity activity) {

        transaction.begin();

        entityManager.merge(activity);

        transaction.commit();

        return activity;
    }

    @Override
    public List<Activity> findAll() {
        return entityManager.createQuery("from Activity ", Activity.class).getResultList();
    }

    @Override
    public List<Activity> findAllById(Long[] id) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Activity findById(Long id) {
        List<Activity> activities = entityManager.createQuery("from Activity a " +
                "where a.id = :id").setParameter("id", id).getResultList();
        return activities.get(0);
    }

    @Override
    public Boolean existsById(Long aLong) {
        return null;
    }
}

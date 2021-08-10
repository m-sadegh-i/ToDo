package ir.maktab.todo.base.service;

import ir.maktab.todo.base.domain.BaseEntity;

import java.util.List;

public interface BaseService<E extends BaseEntity<ID>, ID> {

    E save(E e);

    E update(E e);

    List<E> findAll();

    List<E> findAllById(ID[] ids);

    void deleteById(ID id);

    E findById(ID id);

}

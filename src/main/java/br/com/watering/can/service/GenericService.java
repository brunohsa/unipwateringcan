package br.com.watering.can.service;

import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;

public abstract class GenericService<E> implements IGenericService<E> {


    protected abstract CrudRepository getRepository();

    @Override
    public E save(E entity) {
        return (E) getRepository().save(entity);
    }

    @Override
    public List<E> findAll() {
        return (List<E>) getRepository().findAll();
    }

    @Override
    public E findById(Long id) {
        return (E) getRepository().findOne(id);
    }

    @Override
    public void delete(Long id) {
        getRepository().delete(id);
    }
}

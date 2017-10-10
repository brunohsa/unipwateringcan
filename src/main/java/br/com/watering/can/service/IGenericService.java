package br.com.watering.can.service;

import java.util.List;

public interface IGenericService<E> {

    public E save(E entity);

    public List<E> findAll();

    public E findById(Long id);

    public void delete(Long id);
}

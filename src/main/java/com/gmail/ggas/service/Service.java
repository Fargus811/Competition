package com.gmail.ggas.service;

import com.gmail.ggas.entity.Entity;

import java.util.List;

public interface Service<T extends Entity> {

    void deleteById(long id );

    List<T> findAll();

    List<T> findAll(int page, int pageSize);

    void update(T entity) throws Exception;

    void create(T entity) throws Exception;
}

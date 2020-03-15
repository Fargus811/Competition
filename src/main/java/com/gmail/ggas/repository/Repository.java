package com.gmail.ggas.repository;

import java.util.List;

public interface Repository<T> {

    void create(T entity);

    List<T> findAll();

    List<T> findAll(int page, int limit);

    T findById(long id);

    void deleteById(long id);

    void update(T entity);


}

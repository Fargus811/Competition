package com.gmail.ggas.repository;

import com.gmail.ggas.exception.UserLoginException;

import java.util.List;

public interface Repository<T> {

    void save(T entity);

    List<T> findAll();

    T findById(long id);

    void deleteById(long id);

    void update(T entity);

    T findByLogin(String login) throws UserLoginException;

}

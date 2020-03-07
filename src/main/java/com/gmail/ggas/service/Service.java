package com.gmail.ggas.service;

import java.util.List;

public interface Service<T> {

    void deleteById(long id );

    List<T> findAll();

    void update(List<String> params) throws Exception;

    void createPerson(List<String> params) throws Exception;
}

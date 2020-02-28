package com.gmail.ggas.service;

import com.gmail.ggas.entity.User;

import java.util.List;

public interface Service {

    void deleteById(long id );

    List<User> findAll();

    void update(List<String> params) throws Exception;

    void createPerson(List<String> params) throws Exception;
}

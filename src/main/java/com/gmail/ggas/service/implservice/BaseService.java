package com.gmail.ggas.service.implservice;

import com.gmail.ggas.entity.Entity;
import com.gmail.ggas.exception.CoachServiceException;
import com.gmail.ggas.repository.Repository;
import com.gmail.ggas.service.Service;

import java.util.List;

public abstract class BaseService<T extends Entity> implements Service<T> {


    protected abstract Repository<T> getRepository();

    @Override
    public void create(T entity) throws Exception {
        try {
            getRepository().create(entity);
        } catch (Exception e) {
            throw new CoachServiceException(e);
        }

    }

    //TODO сделать булин переменную ради сообщения об ошибке
    @Override
    public void deleteById(long id) {
        T entity = getRepository().findById(id);
        if (entity == null) {
            System.out.println("Пользователь с таким id:" + id + " не найден");
        } else {
            getRepository().deleteById(id);
        }

    }

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public List<T> findAll(int page, int pageSize) {
        return getRepository().findAll(page, pageSize);
    }

    @Override
    public void update(T entity) throws Exception {
        getRepository().update(entity);
    }
}

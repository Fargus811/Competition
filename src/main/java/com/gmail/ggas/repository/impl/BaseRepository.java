package com.gmail.ggas.repository.impl;

import com.gmail.ggas.entity.Entity;
import com.gmail.ggas.exception.RepositoryException;
import com.gmail.ggas.file.EntityKeyValueFileStore;
import com.gmail.ggas.repository.Repository;
import com.gmail.ggas.repository.condition.Condition;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BaseRepository<T extends Entity> implements Repository<T> {

    private final static Logger log = Logger.getLogger(BaseRepository.class);


    private EntityKeyValueFileStore entityKeyValueFileStore;


    public BaseRepository(String relativePath) {
        this.entityKeyValueFileStore = new EntityKeyValueFileStore(relativePath);
    }

    @Override
    public void update(T entity) {
        String id = String.valueOf(entity.getId());
        List<String> entityLines = entityKeyValueFileStore.readAllLines();
        List<String> entityResult = new ArrayList<>();
        for (String line : entityLines) {
            if (!entityKeyValueFileStore.retrieveIdFromLine(line).equals(id)) {
                entityResult.add(line);
            }
        }
        entityResult.add(buildLine(entity));
        entityKeyValueFileStore.writeLinesToFile(entityResult);
    }

    //TODO отпимизировать запись в конец файла
    @Override
    public void create(T entity) {
        entity.setId(entityKeyValueFileStore.readMaxId() + 1);
        String coachLine = buildLine(entity);
        List<String> lines = entityKeyValueFileStore.readAllLines();
        lines.add(coachLine);
        log.debug("Create entity with id " + entity.getId());
        entityKeyValueFileStore.writeLinesToFile(lines);
    }

    @Override
    public void deleteById(long id) {
        entityKeyValueFileStore.deleteById(id);
        log.debug("Delete entity with id " + id);
    }

    @Override
    public List<T> findAll() {
        List<String> coachLines = entityKeyValueFileStore.readAllLines();
        List<T> entityResult = new ArrayList<>();
        for (String line : coachLines) {
            entityResult.add(buildEntity(line));
        }
        return entityResult;
    }

    @Override
    public List<T> findAll(int page, int pageSize) {
        //return findAll().stream().skip((page - 1) * pageSize).limit(pageSize);
        List<T> entities = findAll();
        int offset = (page - 1) * pageSize;
        if (offset >= entities.size()) {
            return Collections.emptyList();
        }
        int lastIndex = offset + pageSize;
        lastIndex = (lastIndex >= entities.size()) ? entities.size() - 1 : lastIndex;
        return entities.subList(offset, lastIndex);
    }

    @Override
    public T findById(long id) {
        String entityLine = entityKeyValueFileStore.readLineById(String.valueOf(id));
        return entityLine == null ? null : buildEntity(entityLine);
    }

    protected T findOneByCondition(Condition condition) throws RepositoryException {
        List<T> entities = findListByCondition(condition);
        if (CollectionUtils.isEmpty(entities)) {
            return null;
        } else if (entities.size() > 1) {
            throw new RepositoryException("Illegal number of entities ");
        }
        return entities.get(0);
    }

    protected List<T> findListByCondition(Condition condition) {
        List<String> lines = entityKeyValueFileStore.readAllLines();
        List<T> entities = new ArrayList<>();
        List<T> resultEntities = new ArrayList<>();
        for (String line : lines) {
            entities.add(buildEntity(line));
        }
        for (T entity : entities) {
            if (condition.check(entity)) {
                resultEntities.add(entity);
            }
        }
        return resultEntities;
    }

    protected abstract String buildLine(T entity);

    protected abstract T buildEntity(String line);
}

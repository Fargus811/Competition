package com.gmail.ggas.repository.condition;

public interface Condition<T> {

    boolean check(T entity);
}

package org.example.springjdbc_demo.repos;

import java.util.List;

public interface IBaseRepo<T, U> {
    List<T> getAll();
    T getById(U u);
    int save(T t);
    int delete(U u);
}

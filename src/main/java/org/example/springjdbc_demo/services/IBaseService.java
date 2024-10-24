package org.example.springjdbc_demo.services;

import java.util.List;

public interface IBaseService<T, U, K> {
    List<T> getAll();
    T getById(K k);
    int save(U u);
    int delete(K k);
}

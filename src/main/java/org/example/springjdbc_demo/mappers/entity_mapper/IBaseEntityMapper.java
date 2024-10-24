package org.example.springjdbc_demo.mappers.entity_mapper;

public interface IBaseEntityMapper<D, E, M> {
    D toDto(E e);
    E toEntity(M m);
}

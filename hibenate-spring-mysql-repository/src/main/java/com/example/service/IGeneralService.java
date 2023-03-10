package com.example.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    List<T> findAll();
    Optional<T> findById(long id);
    void save(T t);
    void remove(long id);
}

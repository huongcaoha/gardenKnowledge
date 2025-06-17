package com.ra.session01.service;

import java.util.List;

public interface IService<T,E> {
     List<T> findAll() ;
     T findById(E id) ;
     T save(T t) ;
     T update(T t) ;
     boolean delete(E id) ;
}

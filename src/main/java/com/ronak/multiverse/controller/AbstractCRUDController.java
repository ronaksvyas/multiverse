package com.ronak.multiverse.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

public interface AbstractCRUDController<T, ID extends Serializable> {

  Page<T> get(Integer var1, Integer var2);

  T save(T var1);

  List<T> saveAll(List<T> var1);

  Optional<T> getById(ID var1);

  void deleteById(ID var1);
}


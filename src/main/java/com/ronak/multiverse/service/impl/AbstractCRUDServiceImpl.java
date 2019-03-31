package com.ronak.multiverse.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ronak.multiverse.service.AbstractCRUDService;

public abstract class AbstractCRUDServiceImpl<T, ID extends Serializable, R extends JpaRepository<T, ID>> implements AbstractCRUDService<T, ID> {
  public AbstractCRUDServiceImpl() {
  }

  public Page<T> get(final Integer page, final Integer size) {
    return this.getRepository().findAll(PageRequest.of(page, size));
  }

  public T save(final T t) {
    return this.getRepository().save(t);
  }

  public Optional<T> getById(final ID id) {
    return this.getRepository().findById(id);
  }

  public void deleteById(final ID id) {
    this.getRepository().deleteById(id);
  }

  public List<T> saveAll(final List<T> list) {
    return this.getRepository().saveAll(list);
  }

  public abstract R getRepository();
}

package com.ronak.multiverse.controller.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ronak.multiverse.constants.RESTContants;
import com.ronak.multiverse.controller.AbstractCRUDController;
import com.ronak.multiverse.service.impl.AbstractCRUDServiceImpl;

/**
 * AbstractCRUD Controller supports basic CRUD operations
 * It implements AbstractCRUDController
 * It uses Generics to carry out the operations in generic way
 * @param <S>
 * @param <T>
 * @param <ID>
 */
public abstract class AbstractCRUDControllerImpl<S extends AbstractCRUDServiceImpl, T, ID extends Serializable> implements AbstractCRUDController<T, ID>{

  public abstract S getService();

  @GetMapping(RESTContants.GET_ALL)
  public Page<T> get(@RequestParam(defaultValue = "0") final Integer page,
      @RequestParam(defaultValue = "100") final Integer size) {
    return this.getService().get(page, size);
  }

  @PostMapping(RESTContants.SAVE_ONE)
  public T save(@RequestParam final T t) {
    return (T) this.getService().save(t);
  }

  @GetMapping(RESTContants.GET_BY_ID)
  public Optional<T> getById(@RequestParam final ID id) {
    return this.getService().getById(id);
  }

  @DeleteMapping(RESTContants.DEL_BY_ID)
  public void deleteById(@PathParam(value = "id") final ID id) {
    this.getService().deleteById(id);
  }

  @PostMapping(RESTContants.SAVE_ALL)
  public List<T> saveAll(@RequestBody final List<T> list) {
    return this.getService().saveAll(list);
  }
}
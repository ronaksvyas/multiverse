package com.ronak.multiverse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronak.multiverse.model.Person;
import com.ronak.multiverse.repository.PersonRepo;

@Service
public class PersonServiceImpl extends AbstractCRUDServiceImpl<Person, Long, PersonRepo>{

  @Autowired
  private PersonRepo personRepo;

  @Override
  public PersonRepo getRepository() {
    return personRepo;
  }
}

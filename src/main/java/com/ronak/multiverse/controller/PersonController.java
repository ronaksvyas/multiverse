package com.ronak.multiverse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ronak.multiverse.constants.RESTContants;
import com.ronak.multiverse.controller.impl.AbstractCRUDControllerImpl;
import com.ronak.multiverse.model.Person;
import com.ronak.multiverse.service.impl.PersonServiceImpl;

@RestController
@RequestMapping(RESTContants.PERSON)
public class PersonController extends AbstractCRUDControllerImpl<PersonServiceImpl, Person, Long> {

  @Autowired
  private PersonServiceImpl personService;

  @Override
  public PersonServiceImpl getService() {
    return personService;
  }
}
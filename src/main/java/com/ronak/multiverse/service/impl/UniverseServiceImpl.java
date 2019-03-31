package com.ronak.multiverse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronak.multiverse.model.Universe;
import com.ronak.multiverse.repository.UniverseRepo;

@Service
public class UniverseServiceImpl extends AbstractCRUDServiceImpl<Universe, Long, UniverseRepo> {

  @Autowired
  private UniverseRepo universeRepo;

  @Autowired
  private FamilyServiceImpl familyService;

  @Override
  public UniverseRepo getRepository() {
    return universeRepo;
  }

  public List<String> getAllFamiliesInUniverse(final Long universeId){
    return familyService.getByUniverse(universeId);
  }

}

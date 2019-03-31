package com.ronak.multiverse.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronak.multiverse.model.Family;
import com.ronak.multiverse.model.Person;
import com.ronak.multiverse.repository.FamilyRepo;
import com.ronak.multiverse.repository.PersonRepo;
import com.ronak.multiverse.repository.enums.Power;
import com.ronak.multiverse.service.FamilyService;

@Service
public class FamilyServiceImpl extends AbstractCRUDServiceImpl<Family, Long, FamilyRepo> implements
    FamilyService{

  @Autowired
  private FamilyRepo familyRepo;

  @Autowired
  private PersonRepo personRepo;

  @Override
  public FamilyRepo getRepository() {
    return familyRepo;
  }

  @Override
  public List<String> getByUniverse(final Long universeId) {
    if(universeId == null){
      return new ArrayList<>();
    }

    return familyRepo.findAllByUniverseId(universeId);
  }

  @Override
  public List<String> getPowersOfAllMembers(final Long familyId) {
    return familyRepo.findPowerOfFamily(familyId);
  }

  @Override
  public List<BigInteger> getDistinctFamilyIds() {
    return familyRepo.findDistinctIds();
  }

  @Override
  public void balanceFamily(final Long familyId) {
    final List<BigInteger> personIds = personRepo.findIdsByFamilyId(familyId);
    personIds.forEach(id -> {
      final Optional<Person> personOptional = personRepo.findById(id.longValue());
      if(personOptional.isPresent()){
        final Person p =personOptional.get();
        p.setPower(Power.POSITIVE);
        personRepo.save(p);
      }
    });
  }
}

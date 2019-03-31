package com.ronak.multiverse.service;

import java.math.BigInteger;
import java.util.List;

import com.ronak.multiverse.model.Family;

public interface FamilyService extends AbstractCRUDService<Family, Long> {
  public List<String> getByUniverse(final Long universeId);

  public List<String> getPowersOfAllMembers(final Long familyId);

  public List<BigInteger> getDistinctFamilyIds();

  public void balanceFamily(final Long familyId);
}

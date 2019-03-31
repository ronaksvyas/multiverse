package com.ronak.multiverse.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ronak.multiverse.constants.ParamConstants;
import com.ronak.multiverse.constants.RESTContants;
import com.ronak.multiverse.controller.impl.AbstractCRUDControllerImpl;
import com.ronak.multiverse.model.Family;
import com.ronak.multiverse.service.impl.FamilyServiceImpl;

import javassist.NotFoundException;

@RestController
@RequestMapping(RESTContants.FAMILY)
public class FamilyController extends AbstractCRUDControllerImpl<FamilyServiceImpl, Family, Long> {

  @Autowired
  private FamilyServiceImpl familyService;

  @Override
  public FamilyServiceImpl getService() {
    return familyService;
  }

  /**
   * Method to check if given family id has same power
   * @param familyId
   * @return
   * @throws NotFoundException
   */
  @GetMapping(RESTContants.CHECK_SAME_POWER)
  public Boolean checkIfSamePower(@PathVariable(ParamConstants.FAMILY_ID) final Long familyId) throws NotFoundException{
    final List<String> powers = familyService.getPowersOfAllMembers(familyId);
    if(powers == null || powers.isEmpty()){
      throw new NotFoundException("No persons found in given family");
    }
    return powers.stream().distinct().count() <= 1;
  }

  /**
   * Method to find the family id with unbalanced powers
   * @return
   * @throws NotFoundException
   */
  @GetMapping(RESTContants.UNBALANCED_FAMILY_ID)
  public List<BigInteger> findUnbalancedFamilyIds() throws NotFoundException{
    final List<BigInteger> ids = familyService.getDistinctFamilyIds();
    if(ids == null || ids.isEmpty()){
      throw new NotFoundException("No families found");
    }

    final List<BigInteger> unbalanced = new ArrayList<>();

    ids.forEach(id -> {
      final List<String> powers = familyService.getPowersOfAllMembers(id.longValue());
      if(powers.stream().distinct().count() <= 1){
        unbalanced.add(id);
      }
    });

    return unbalanced;
  }

  /**
   * Method to balance a family
   * It assigns everyone a positive power
   * @param familyid
   */
  @GetMapping(RESTContants.BALANCE_FAMILY)
  public void balanceFamily(@PathVariable(ParamConstants.FAMILY_ID) final Long familyid){
    familyService.balanceFamily(familyid);
  }
}

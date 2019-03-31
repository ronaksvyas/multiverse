package com.ronak.multiverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ronak.multiverse.constants.ParamConstants;
import com.ronak.multiverse.constants.RESTContants;
import com.ronak.multiverse.controller.impl.AbstractCRUDControllerImpl;
import com.ronak.multiverse.model.Universe;
import com.ronak.multiverse.service.impl.UniverseServiceImpl;

@RestController
@RequestMapping(RESTContants.UNIVERSE)
public class UniverseController extends
    AbstractCRUDControllerImpl<UniverseServiceImpl, Universe, Long> {

  @Autowired
  protected UniverseServiceImpl universeService;

  @Override
  public UniverseServiceImpl getService() {
    return universeService;
  }

  @GetMapping(RESTContants.FAMILIES_IN_UNIVERSE)
  public List<String> getAllFamiliesInUniverse(
      @PathVariable(ParamConstants.UNIVERSE_ID) final Long universeId){
    return universeService.getAllFamiliesInUniverse(universeId);
  }
  }
package com.ronak.multiverse.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ronak.multiverse.model.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {

  @Query(value = "select\n"
      + "\tp.id\n"
      + "from\n"
      + "\tmultiverse.person p\n"
      + "INNER JOIN multiverse.family_has_persons fhp on\n"
      + "\tfhp.persons_id = p.id\n"
      + "where\n"
      + "\tfhp.family_id = :familyId ;", nativeQuery = true)
  List<BigInteger> findIdsByFamilyId(@Param("familyId") final Long familyId);
}

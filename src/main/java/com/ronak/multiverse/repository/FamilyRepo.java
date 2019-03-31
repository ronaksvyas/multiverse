package com.ronak.multiverse.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ronak.multiverse.model.Family;

@Repository
public interface FamilyRepo extends JpaRepository<Family, Long>{

  @Query(value = "select distinct id from multiverse.family", nativeQuery = true)
  public List<BigInteger> findDistinctIds();

  @Query(value = "select\n"
      + "\tf.name\n"
      + "from\n"
      + "\tmultiverse.family f\n"
      + "INNER JOIN multiverse.family_has_persons fhs on\n"
      + "\tf.id = fhs.family_id\n"
      + "INNER JOIN multiverse.person p on\n"
      + "\tp.id = fhs.persons_id\n"
      + "where\n"
      + "\tp.universe_id = :id\n"
      + "group by\n"
      + "\tf.id,\n"
      + "\tf.name;\n", nativeQuery = true)
  List<String> findAllByUniverseId(@Param("id") final Long universeId);

  @Query(value = "SELECT\n"
      + "\tpower\n"
      + "from\n"
      + "\tmultiverse.person p\n"
      + "INNER JOIN multiverse.family_has_persons fhp on\n"
      + "\tp.id = fhp.persons_id where fhp.family_id = :familyId ; ", nativeQuery = true)
  List<String> findPowerOfFamily(@Param("familyId") final Long familyId);
}

package com.ronak.multiverse.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.ronak.multiverse.constants.ColumnConstants;
import com.ronak.multiverse.constants.TableNameConstants;

import lombok.Data;

/**
 * FamilyRepo entity representing a family
 */
@Data
@Entity
public class Family {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  @OneToMany
  @CollectionTable(name = TableNameConstants.FAMILY_HAS_PERSONS)
  private List<Person> persons;

}

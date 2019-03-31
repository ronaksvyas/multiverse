package com.ronak.multiverse.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ronak.multiverse.constants.TableNameConstants;

import lombok.Data;

/**
 * Entity representing a person in the multiverse
 * This person has different identites in different universes
 * This person, for now, just has Id, no name because this is not a real entity
 * It has a list of all persons in different universe
 * A Multiverse person has one to many relationship with Universe person
 */
@Data
@Entity
@Table(name = "multiverse_person", catalog = "multiverse")
public class MultiversePerson {
  @Id
  private Long id;

  //all persons who are versions of this person in parallel universes

  @OneToMany
  @CollectionTable(name = TableNameConstants.MULTIVERSE_HAS_UNIVERSE_PERSONS)
  private List<Person> universePersons;
}

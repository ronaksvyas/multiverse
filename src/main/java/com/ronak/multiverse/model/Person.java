package com.ronak.multiverse.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ronak.multiverse.constants.ColumnConstants;
import com.ronak.multiverse.repository.enums.Power;

import lombok.Data;

/**
 * Entity representing a person in a universe
 */
@Data
@Entity
@Table(name = "person", catalog = "multiverse")
public class Person {

  //id of the person
  //primary key
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  //name of the person in this universe
  private String name;

  //power of the person
  @Enumerated(EnumType.STRING)
  private Power power;

  //mapping of a person and an universe
  @ManyToOne
  @JoinColumn(name = ColumnConstants.UNIVERSE_ID)
  private Universe universe;
}

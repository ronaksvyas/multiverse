package com.ronak.multiverse.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Universe entity
 * All getters, setters and overriden methods generated by lombok
 */
@Data
@Entity
@Table(name = "universe", catalog = "multiverse")
public class Universe{

  //ID of the universe
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  //name of the universe
  private String name;
}

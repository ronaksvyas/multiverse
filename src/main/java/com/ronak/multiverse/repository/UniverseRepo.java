package com.ronak.multiverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ronak.multiverse.model.Universe;

@Repository
public interface UniverseRepo extends JpaRepository<Universe,Long>{
}

package com.gslab.talent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gslab.talent.model.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {

}

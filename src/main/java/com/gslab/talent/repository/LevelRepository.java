package com.gslab.talent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gslab.talent.model.Level;
import com.gslab.talent.model.User;

@Repository
public interface LevelRepository extends JpaRepository<Level, Integer>{

	Level deleteByDescription(Level level);

}

package com.gslab.talent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gslab.talent.model.Position;
import com.gslab.talent.repository.PositionRepository;

@Service
public class PositionServiceImpl implements PositionService {
	@Autowired
	PositionRepository posRepoObj;

	@Override
	public List<Position> getAllPositions() {
		return posRepoObj.findAll();
	}

	@Override
	public Position getPositionById(int posId) {
		return posRepoObj.findById(posId).orElse(null);
	}

	@Override
	public void createNewPosition(Position position) {
		posRepoObj.save(position);

	}

	@Override
	public void updatePosition(Position position) {
		posRepoObj.save(position);

	}

	@Override
	public void deletePositionById(int posId) {
		posRepoObj.deleteById(posId);

	}

	@Override
	public void deleteAllPosition() {
		posRepoObj.deleteAll();

	}

}

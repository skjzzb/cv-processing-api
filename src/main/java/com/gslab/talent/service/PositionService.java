package com.gslab.talent.service;

import java.util.List;

import com.gslab.talent.model.Position;

public interface PositionService {
	List<Position> getAllPositions();
	Position getPositionById(int posId);
	void createNewPosition(Position position);
	void updatePosition(Position position);
	void deletePositionById(int posId);
	void deleteAllPosition();
}

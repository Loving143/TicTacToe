package com.parkinglot.service;

import com.parkinglot.enumm.Symbol;
import com.parkinglot.model.Board;
import com.parkinglot.model.Move;

public interface PlayerInterface {

	String getName();
	Symbol getSymbol();
	Move getMove(Board board);
	
}

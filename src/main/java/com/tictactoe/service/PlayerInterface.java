package com.tictactoe.service;

import com.tictactoe.enumm.Symbol;
import com.tictactoe.model.Board;
import com.tictactoe.model.Move;

public interface PlayerInterface {

	String getName();
	Symbol getSymbol();
	Move getMove(Board board);
	
}

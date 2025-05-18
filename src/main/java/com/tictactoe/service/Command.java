package com.tictactoe.service;

public interface Command {
	void undo();
	boolean  execute();
}

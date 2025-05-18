package com.parkinglot.service;

public interface Command {
	void undo();
	boolean  execute();
}

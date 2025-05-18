package com.parkinglot.model;

import java.util.List;
import java.util.Stack;

import com.parkinglot.service.Command;

public class GameController {
	List<Player>playerList;
    private Stack<Command> history = new Stack<>();

    public boolean  executeCommand(Command command) {
        if(command.execute()) {
        	history.push(command);
        	return true;
        }
        return false;
    }

    public void undoLastMove() {
        if (!history.isEmpty()) {
            Command lastMove = history.pop();
            lastMove.undo();
        }
    }

	public List<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}
}

// === MoveCommand.java ===
package com.parkinglot;

import com.parkinglot.model.Board;
import com.parkinglot.model.Player;
import com.parkinglot.service.Command;
import com.parkinglot.service.PlayerInterface;

public class MoveCommand implements Command {
    private final Board board;
    private final int row;
    private final int col;
    private PlayerInterface player;

    public  MoveCommand(Board board, int row, int col, PlayerInterface player) {
        this.board = board;
        this.row = row;
        this.col = col;
        this.player = player;
    }

    @Override
    public boolean execute() {
    	return board.markCell(row, col, player.getSymbol());
    }

    public void undo() {	
    	board.undoMove(row, col);
    }

    public int getRow() { return row; }
    public int getCol() { return col; }
}

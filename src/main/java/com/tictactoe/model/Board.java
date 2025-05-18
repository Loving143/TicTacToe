package com.tictactoe.model;

import com.tictactoe.enumm.Symbol;

public class Board {
    private final int size;
    private final Cell[][] cells;

    public Board(int size) {
        this.size = size;
        cells = new Cell[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                cells[i][j] = new Cell(i, j);
    }

   

	public boolean markCell(int row, int col, Symbol symbol) {
		if(row>=size || col >=size || row <0 || col<0)
			return false;
        if (cells[row][col].isEmpty()) { 
            cells[row][col].setSymbol(symbol);
            return true;
        }
        return false;
    }

    public boolean checkWin(Symbol symbol) {
        // check rows
        for (int i = 0; i < size; i++)
            if (checkLine(symbol, cells[i])) return true;

        // check columns
        for (int j = 0; j < size; j++) {
            boolean colWin = true;
            for (int i = 0; i < size; i++) {
                if (cells[i][j].getSymbol() != symbol) {
                    colWin = false; break;
                }
            }
            if (colWin) return true;
        }

        // check diagonals
        boolean mainDiag = true, antiDiag = true;
        for (int i = 0; i < size; i++) {
            if (cells[i][i].getSymbol() != symbol) mainDiag = false;
            if (cells[i][size - i - 1].getSymbol() != symbol) antiDiag = false;
        }
        return mainDiag || antiDiag;
    }

    private boolean checkLine(Symbol symbol, Cell[] row) {
        for (Cell c : row)
            if (c.getSymbol() != symbol) return false;
        return true;
    }

    public boolean isFull() {
        for (Cell[] row : cells)
            for (Cell c : row)
                if (c.isEmpty()) return false;
        return true;
    }

    public void printBoard() {
        for (Cell[] row : cells) {
        	System.out.print("|");
            for (Cell c : row) {
                System.out.print(c.getSymbol() != null ? c.getSymbol() : "_");
                System.out.print(" ");
            }
            System.out.println("|");
        }
    }

	public int getSize() {
		return size;
	}

	public Cell[][] getCells() {
		return cells;
	}

	public void makeMove(int row, int col, Symbol player) {
		 cells[row][col].setSymbol(player);
		
	}
	public void undoMove(int row, int col) {
        cells[row][col].setSymbol(null);
    }

}


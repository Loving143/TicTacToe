package com.tictactoe.model;

import com.tictactoe.enumm.Symbol;

public class Cell {
    private int row, col;
    private Symbol symbol;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.symbol = null;
    }

    public boolean isEmpty() {
        return symbol == null;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Symbol getSymbol() {
        return symbol;
    }
}

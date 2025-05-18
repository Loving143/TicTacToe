// === Player.java ===
package com.tictactoe.model;

import java.util.Scanner;

import com.tictactoe.MoveCommand;
import com.tictactoe.enumm.Symbol;

public class Player {
    private final String name;
    private final Symbol symbol;

    public Player(String name, char symbol) {
        this.name = name;
        if(symbol=='X') {
        	this.symbol = Symbol.X;
        }else {
        	this.symbol = Symbol.O;
        }
    }

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }
}

// === Player.java ===
package com.parkinglot.model;

import java.util.Scanner;

import com.parkinglot.MoveCommand;
import com.parkinglot.enumm.Symbol;

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

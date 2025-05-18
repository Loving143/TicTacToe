package com.parkinglot.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.parkinglot.enumm.Symbol;
import com.parkinglot.service.PlayerInterface;

public class RandomBotPlayer implements PlayerInterface {
private final Symbol symbol;
private final String name;
private final Random random = new Random();

public RandomBotPlayer(String name, Symbol symbol) {
    this.name = name;
    this.symbol = symbol;
}

public String getName() { return name; }
public Symbol getSymbol() { return symbol; }

public Move getMove(Board board) {
    List<Move> emptyCells = new ArrayList<>();
    for (int i = 0; i < board.getSize(); i++) {
        for (int j = 0; j < board.getSize(); j++) {
            if (board.getCells()[i][j].getSymbol() == null) {
                emptyCells.add(new Move(i, j));
            }
        }
    }
    System.out.println(emptyCells.size()+"This is empty size ");
    return emptyCells.get(random.nextInt(emptyCells.size()));
}
}

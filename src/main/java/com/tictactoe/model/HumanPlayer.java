package com.tictactoe.model;

import java.util.Scanner;

import com.tictactoe.enumm.Symbol;
import com.tictactoe.service.PlayerInterface;

public class HumanPlayer implements PlayerInterface
{

	 	private final String name;
	    private final Symbol symbol;
	    private final Scanner scanner = new Scanner(System.in);

	    public HumanPlayer(String name, Symbol symbol) {
	        this.name = name;
	        this.symbol = symbol;
	    }

	    public String getName() { return name; }
	    public Symbol getSymbol() { return symbol; }

	    public Move getMove(Board board) {
	        System.out.println(name + ", enter your move (row and column): ");
	        int row = scanner.nextInt();
	        int col = scanner.nextInt();
	        return new Move(row, col);
	    }

}

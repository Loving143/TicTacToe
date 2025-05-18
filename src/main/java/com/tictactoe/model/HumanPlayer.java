package com.tictactoe.model;

import java.time.LocalTime;
import java.util.Scanner;

import com.tictactoe.enumm.Symbol;
import com.tictactoe.service.PlayerInterface;

public class HumanPlayer implements PlayerInterface
{

	 	private final String name;
	    private final Symbol symbol;
	    private final Scanner scanner = new Scanner(System.in);
	    private LocalTime timeFrom;

	    public HumanPlayer(String name, Symbol symbol) {
	        this.name = name;
	        this.symbol = symbol;
	    }

	    public String getName() { return name; }
	    public Symbol getSymbol() { return symbol; }

	    public Move getMove(Board board) {
	    	timeFrom = LocalTime.now();
	        System.out.println(name + ", enter your move (row and column): ");
	        int row = scanner.nextInt();
	        int col = scanner.nextInt();
	        return new Move(row, col);
	    }

		public LocalTime getTimeFrom() {
			return timeFrom;
		}

		public void setTimeFrom(LocalTime timeFrom) {
			this.timeFrom = timeFrom;
		}

		public Scanner getScanner() {
			return scanner;
		}

}

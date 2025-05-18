package com.parkinglot;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.parkinglot.enumm.Symbol;
import com.parkinglot.model.Board;
import com.parkinglot.model.GameController;
import com.parkinglot.model.HumanPlayer;
import com.parkinglot.model.Move;
import com.parkinglot.model.RandomBotPlayer;
import com.parkinglot.service.Command;
import com.parkinglot.service.PlayerInterface;

@SpringBootApplication
public class TicTacToeApplication {

	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
//		System.out.println("Please enter the Board size");
//		int boardSize = sc.nextInt();
//		System.out.println("Please enter first player name");
//		String playerName1 = sc.next();
//		System.out.println("Please enter second player name");
//		String playerName2 = sc.next();
//		System.out.println("Chose the Sysmbol from the list");
//		System.out.println("     X     ");
//		System.out.println("    O   ");
//		System.out.println("Player one enter symbol");
//		char symbol1 = sc.next().charAt(0);
//		System.out.println("Player two enter symbol");
//		char symbol2 = sc.next().charAt(0);
		
		
		 Scanner sc = new Scanner(System.in);

	        System.out.println("Enter board size (e.g., 3 for 3x3): ");
	        int size = sc.nextInt();
	        Board board = new Board(size);

	        System.out.println("Choose Game Mode:\n1. Player vs Player\n2. Player vs Bot\n3. Bot vs Bot");
	        int choice = sc.nextInt();

	        PlayerInterface player1, player2;

	        if (choice == 1) {
	            System.out.println("Enter Player 1 name:");
	            player1 = new HumanPlayer(sc.next(), Symbol.X);
	            System.out.println("Enter Player 2 name:");
	            player2 = new HumanPlayer(sc.next(), Symbol.O);
	        } else if (choice == 2) {
	            System.out.println("Enter your name:");
	            player1 = new HumanPlayer(sc.next(), Symbol.X);
	            player2 = new RandomBotPlayer("Bot", Symbol.O);
	        } else {
	            player1 = new RandomBotPlayer("Bot1", Symbol.X);
	            player2 = new RandomBotPlayer("Bot2", Symbol.O);
	        }
		PlayerInterface currentPlayer = player1;
	      GameController controller = new GameController();

	      while(!board.isFull()) {
	    	  board.printBoard();
	    	  Move move = currentPlayer.getMove(board);
	    	
	    	Command move2 = new MoveCommand(board, move.getRow(),move.getCol(),currentPlayer );
	    	if(!controller.executeCommand(move2)) {
	    		System.out.println("Invalid move. Try again.");
                continue;
	    	}
	    	System.out.println("Do you want to undo.Y Or N");
	    	char undo = sc.next().charAt(0);
	    	if(undo=='Y' || undo =='y') {
	    		controller.undoLastMove();
	    		continue;
	    	}
	    	
	    	if (board.checkWin(currentPlayer.getSymbol())) {
                board.printBoard();
                System.out.println("Winner is: " + currentPlayer.getName());
                return;
            }
	    	  currentPlayer = (currentPlayer == player1) ? player2 : player1;
	      }

	        board.printBoard();
	        System.out.println("Game Draw!");

	        board.printBoard();
	        System.out.println("Undo last move:");
	        controller.undoLastMove();
	        board.printBoard();
		

	}

}

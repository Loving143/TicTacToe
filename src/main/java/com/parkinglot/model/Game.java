//// === Game.java ===
//package com.parkinglot.model;
//
//import java.util.List;
//import java.util.Stack;
//
//import com.parkinglot.MoveCommand;
//
//public class Game {
//    private final Board board;
//    private final List<Player> players;
//    private Player currentPlayer;
//    private Player winner;
//
//    private Stack<MoveCommand> undoStack = new Stack<>();
//    private Stack<MoveCommand> redoStack = new Stack<>();
//
//    public Game(List<Player> players) {
//        this.players = players;
//        this.board = new Board(3);
//        this.currentPlayer = players.get(0);
//    }
//
//    public void play() {
//        while (!board.isFull()) {
//            board.printBoard();
//
//            MoveCommand command = currentPlayer.nextMove(board);
//            if (!command.execute()) {
//                System.out.println("Invalid move. Try again.");
//                continue;
//            }
//
//            undoStack.push(command);
//            redoStack.clear(); // Redo history is cleared on new move
//
//            if (board.checkWin(currentPlayer.getSymbol())) {
//                winner = currentPlayer;
//                board.printBoard();
//                System.out.println("Winner is: " + winner.getName());
//                return;
//            }
//
//            switchPlayer();
//        }
//
//        board.printBoard();
//        System.out.println("Game Draw!");
//    }
//
//    private void switchPlayer() {
//        currentPlayer = (currentPlayer == players.get(0)) ? players.get(1) : players.get(0);
//    }
//
//    public boolean undo() {
//        if (undoStack.isEmpty()) {
//            System.out.println("Nothing to undo.");
//            return false;
//        }
//
//        MoveCommand command = undoStack.pop();
//        command.undo();
//        redoStack.push(command);
//        switchPlayer();
//        return true;
//    }
//
//    public boolean redo() {
//        if (redoStack.isEmpty()) {
//            System.out.println("Nothing to redo.");
//            return false;
//        }
//
//        MoveCommand command = redoStack.pop();
//        command.execute();
//        undoStack.push(command);
//        switchPlayer();
//        return true;
//    }
//}

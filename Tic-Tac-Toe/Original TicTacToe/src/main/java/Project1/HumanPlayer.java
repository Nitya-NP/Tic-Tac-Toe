package Project1;

import java.util.Scanner;

/**
 * Represents a human player in Tic-Tac-Toe.
 * Handles user input for moves and interacts with the game board.
 * 
 * @author Nitya Patel
 */


public class HumanPlayer extends Player{
    
    private Scanner scan;

    /**
     * Constructor to initialize a human player
     * @param symbol X or O
     * @param name the name of the human player
     * @param scan scanner for resding the human player's input
     */
    public HumanPlayer(char symbol,String name,Scanner scan){
        super(symbol, name);
        this.scan=scan;

    }

    /**
     * Handles the human player's move by getting input and placing mark on board
     * @param board the game board on which to make the move
     */
    @Override
    public void move(Board board) {
        while (true) {
            System.out.print(name + ": " + symbol + ", Enter your move as row,column (e.g. 1,2): ");
            try {
                String input = scan.nextLine().trim();

                // Split by comma
                String[] i = input.split(",");

                // Check if we have exactly two numbers
                if (i.length != 2) {
                    System.out.println("Invalid input! Please enter exactly two numbers in format row,col like 2,3");
                    continue;
                }

                //Parse row and column coordinates
                int r = Integer.parseInt(i[0].trim())-1;
                int c = Integer.parseInt(i[1].trim())-1;

                //Attempt to place mark on board
                if (board.placeMark(r, c, symbol)) {
                    break; //Success - exit 
                } 
                else {
                    System.out.println("Invalid move! Try again. Position must be empty and within the grid.");
                }
            } 
            catch (Exception e) {
                System.out.println("Invalid input! Please enter numbers only in format row,col like 2,3");
            } 
        }
    }

}
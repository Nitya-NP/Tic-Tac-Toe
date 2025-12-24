package Project1;

import java.util.Random;

/**
 * Represents a computer-controlled player in Tic-Tac-Toe.
 * Automatically makes moves using a random strategy.
 * 
 * @author Nitya Patel
 */


public class ComputerPlayer extends Player{

    private Random rand; //Random number generator for move selection

    /**
     * Constructor to initialize a computer player
     * @param symbol X or O
     * @param name name of the player
     */
    public ComputerPlayer(char symbol,String name){
        super(symbol, name);
        this.rand=new Random();
    }

    /**
     * Executes the computer player's move by selecting a random valid position
     * @param board the game board on which to make the move
     */
    @Override
    public void move(Board board) {
        System.out.println(name+": "+symbol+" is thinking...");

        int size=board.getSize();
        int r,c;
        
        //Keep generating random positions until a valid move is found
        do{
            r=rand.nextInt(size); //Row
            c=rand.nextInt(size); //Column 
        }while(!board.placeMark(r, c, symbol)); //Repeat until valid move

        System.out.println(name + " placed "+symbol +" at " +(r+1) + ","+(c+1));

    }

}
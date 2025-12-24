package Project2;

/**
 * Abstract base class representing a player in Tic-Tac-Toe.
 * Defines common properties and behaviors for all player types.
 * 
 * @author Nitya Patel
 * 
 */


public abstract class Player {
    
    protected char symbol; //X or O
    protected String name; // name

    /**
     * Constructor to initialize
     * @param symbol X or O
     * @param name the player's name
     */
    public Player(char symbol,String name){
        this.symbol=symbol;
        this.name=name;
    }

    /**
     * Gets the player's symbol
     * @return symbol X or O
     */
    public char getSymbol(){
        return this.symbol;
    }

    /**
     * Gets the player's name
     * @return player's name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Abstract method for making a move on the board
     * @param board the game board on which to make the move
     */
    public abstract void move(Board board);

    /**
     * Prints player object with name and which symbol it has
     * @return string object with player's details
     */
    public String toString() {
        return name + ": " + symbol;
    }
}
package Project2;

/**
 * Manages the extended game flow and logic for customizable Tic-Tac-Toe.
 * Supports NxN boards and custom win length conditions.
 * 
 * @author Nitya Patel
 *
 */


public class ExtendedGame extends Game{
    private ExtendedBoard board;

    /**
     * Constructor to intialize the extended game
     * @param player1 first player
     * @param player2 second player
     * @param size NxN
     * @param winLength number of marks need to win
     */
    public ExtendedGame(Player player1, Player player2, int size,int winLength){
        super(player1, player2, size);
        this.board=new ExtendedBoard(size,winLength);
    }

    /**
     * Starts and manages the main extended game loop
     */
    @Override
    public void play(){
        System.out.println("Game Started! \n" +getPlayer1().getName()+": "+getPlayer1().getSymbol()+" vs "+getPlayer2().getName()+": "+ getPlayer2().getSymbol());
        System.out.println("Board Size: " +board.getSize()+ "x" +board.getSize());
        System.out.println("Winning condition: "+board.getWinLength()+ " in a row");
        boolean active=true;
        
        //Main game loop- Contrinues until game ends
        while (active) {
            board.displayBoard();
            getCurrentPlayer().move(board); //Current player makes their move

            //Check if current player has won
            if(board.checkWin(getCurrentPlayer().getSymbol())){
                board.displayBoard();
                System.out.println(getCurrentPlayer().getName()+", You won!");
                active=false;
            }
            else if(board.isFull()){ //Check if game is a draw
                board.displayBoard();
                System.out.println("Oh, It's draw! Try next time");
                active=false;
            }
            else{ //Continue game with next player
                switchPlayer();
            }
        }
    }
        
    /**
     * Gets the extened board
     * @return ExtenedBoard instance
     */
    @Override
   public ExtendedBoard getBoard(){
        return this.board;
    }
}
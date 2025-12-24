package Project1;

/**
 * Manages the main game flow and logic for Tic-Tac-Toe.
 * Controls player turns, win detection and game flow.
 * 
 * @author Nitya Patel
 */


public class Game{
    private Board board;
    private Player player1;
    private Player player2;
    private Player currPlayer;

    /**
     * Constructor to initialize the game with players and board size
     * @param player1 the first player
     * @param player2 the second player
     * @param size of the board
     */
    public Game(Player player1, Player player2, int size){
        this.board=new Board(size);
        this.player1=player1;
        this.player2=player2;
        this.currPlayer=player1;
    }

    /**
     * Manages the main game loop and logic
     * Handles player turns, win conditions, and game end conditions
     */
    public void play(){
        System.out.println("Game Started! \n" +player1.getName()+": "+player1.getSymbol()+" vs "+player2.getName()+": "+ player2.getSymbol());
        boolean active=true;
        
        //Main game loop- Continue until game ends
        while (active) {
            board.displayBoard();
            currPlayer.move(board); //Current player makes their move

            //Check if current player has won
            if(board.checkWin(currPlayer.getSymbol())){
                board.displayBoard();
                System.out.println(currPlayer.getName()+", You won!");
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
     * Switches to next player's turn 
     */
    public void switchPlayer(){
        if(currPlayer==player1){
            currPlayer=player2;
        }
        else currPlayer=player1;
    }


    /**
     * @return current player - player 1 or player 2
     */
    public Player getCurrentPlayer(){
        return this.currPlayer;
    }

    /**
     * @return current Board
     */
    public Board getBoard(){
        return this.board;
    }

    /**
     * @return Player1 
     */
    public Player getPlayer1(){
        return this.player1;
    }

    /**
     * @return Player2
     */
    public Player getPlayer2(){
        return this.player2;
    }

}
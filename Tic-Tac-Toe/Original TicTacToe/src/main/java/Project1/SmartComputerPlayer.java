package Project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Smart computer player that uses a strategic move priority. Step 6 for Bonus
 * Strategy order: 1. Win 2. Block 3. Center 4. Corner 5. Random
 * 
 * @author Nitya Patel
 */


public class SmartComputerPlayer extends Player{

    private Random rand; //Random number generator for move selection
    private char opponentSymbol; //Player's symbol

    /**
     * Constructor to initialize a smart computer player
     * @param symbol X or O
     * @param name name of the player
     * Initialize the opponents symbol either X or O
     */
    public SmartComputerPlayer(char symbol,String name){
        super(symbol, name);
        this.rand=new Random();

        if(symbol=='X') this.opponentSymbol='O';
        else if(symbol=='O') this.opponentSymbol='X';

    }

    /**
     * Executes the smart computer player's move using strategic priority
     * @param board the game board on which to make the move
     */
    @Override
    public void move(Board board) {
        System.out.println(name+": "+symbol+" is thinking...");

        //1. Try to win if 2 symbols are in line 
        int[] winMove=findWinningMove(board, symbol);
        if(winMove!=null){
            board.placeMark(winMove[0], winMove[1], symbol);
            System.out.println(name + " placed the "+symbol +" at " +(winMove[0]+1) + ","+(winMove[1]+1));
            return;
        }

        //2. Try to block opponent if they have 2 symbol in row place they symbol on the 3rd spot
        int[] blockMove=findWinningMove(board, opponentSymbol);
        if(blockMove!=null){
            board.placeMark(blockMove[0], blockMove[1], symbol);
            System.out.println(name + " placed the "+symbol +" at " +(blockMove[0]+1) + ","+(blockMove[1]+1));
            return;
        }

        //3. Take center if available 
        int center=board.getSize()/2;
        if(board.isValidPosition(center, center)){
            board.placeMark(center, center, symbol);
            System.out.println(name + " placed the "+symbol +" at "+(center+1)+","+(center+1));
            return;
        }

        //4. Take a random corner 
        List<int[]> corners= getCorners(board.getSize());
        List<int[]> avaCorners= new ArrayList<>();
        for(int[] i: corners){ //Check if the corner is empty on the cell
            if(board.isValidPosition(i[0], i[1])){
                avaCorners.add(i);
            }
        }

        //Place at the corner if available 
        if(!avaCorners.isEmpty()){
            int[] chooseCorner= avaCorners.get(rand.nextInt(avaCorners.size()));
            board.placeMark(chooseCorner[0], chooseCorner[1], symbol);
            System.out.println(name + " placed the "+symbol +" at " +(chooseCorner[0]+1) + ","+(chooseCorner[1]+1));
            return;

        }

        //5. Random move if none of the smart strategic works
        int size=board.getSize();
        int r,c;
        
        //Keep generating random positions until a valid move is found
        do{
            r=rand.nextInt(size); //Row
            c=rand.nextInt(size); //Column 
        }while(!board.placeMark(r, c, symbol)); //Repeat until valid move

        System.out.println(name + " placed the "+symbol +" at " +(r+1) + ","+(c+1));

    }

    /**
     * Helper to find a winning move for a given symbol
     * @param board the game board
     * @param symbol X or O 
     * @return coordinates[row,col] of winning move or null
     */
    private int[] findWinningMove(Board board, char symbol){
        int size= board.getSize();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board.isValidPosition(i, j)){
                    board.placeMark(i, j, symbol); //Temporarilty place a symbol
                    boolean win=board.checkWin(symbol); //Check if this move will win or not
                    board.clearCell(i, j); //Undo the temporary moves
                    if(win){
                        return new int[]{i,j};
                    }
                }
            }
        }
        return null;
    }

    /**
     * Helper to get conrer positions for the board
     * @param size
     * @return List of corner coordinates
     */
    private List<int[]> getCorners(int size){
        List<int[]> list= new ArrayList<>();

        list.add(new int[]{0,0});
        list.add(new int[]{0,size-1});
        list.add(new int[]{size-1,0});
        list.add(new int[]{size-1,size-1});

        return list;
    }

}
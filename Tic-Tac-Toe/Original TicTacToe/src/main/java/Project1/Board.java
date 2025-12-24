package Project1;

/**
 * Represents the game board for Tic-Tac-Toe.
 * Manages the grid state, displays the board, place mark and checks game win conditions.
 * 
 * @author Nitya Patel
 * 400555595
 */


public class Board {
    
    private char [][] grid; //2D array game grid
    private int size; //Size of the board 

    /**
     * Constructor to initialize the board 
     * @param size the dimension of the board
     */
    public Board(int size){
        this.size=size;
        this.grid=new char[size][size];
        initializeBoard();

    }

    /**
     * Initializes the board with empty spaces
     */
    private void initializeBoard(){
        for(int i=0; i<size;i++){
            for(int j=0;j<size;j++){
                grid[i][j]=' '; //Set all cells to empty
            }
        }
    }

    /**
     * Displays the current state of the board with needed formatting and X & O placed
     */
    public void displayBoard(){
        System.out.println("\nCurrent Board: ");
        for(int i=0; i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(" "+grid[i][j]+" "); //place the mark  

                if(j<size-1) System.out.print("|"); //Vertical separator between cols
            }
            System.out.println();

            if(i<size-1){
                for (int j = 0; j < size; j++) {
                    System.out.print("---"); //Horizontal separator between rows
                    if (j < size - 1) System.out.print("+"); //Intersection points
                }
                System.out.println();
            }
        }
        System.out.println();
    }
 
    /**
     * Places a player's symbol on the board at specified position
     * @param row index 
     * @param col index 
     * @param symbol X or O
     * @return true if the move was successful, false if invalid
     */
    public boolean placeMark(int row,int col,char symbol){
        if(isValidPosition(row, col)){ //if the position is valid
            grid[row][col]=symbol;
            return true;
        }
        return false;
    }

    /**
     * Checks if the given position is valid and empty
     * @param row index
     * @param col index 
     * @return true if valid, false otherwise
     */
    public boolean isValidPosition(int row,int col){
        return row>=0 && row<size && col>=0 && col<size &&grid[row][col]==' ';
    }

    /**
     * Checks if the given symbol has won the game - (player who has that symbol) 
     * @param symbol player's symbol to check for win
     * @return true if symbol has won. 
     */
    public boolean checkWin(char symbol){
        return checkCols(symbol) || checkDiag(symbol) || checkRows(symbol);
    }

    /**
     * Checks all rows for a winning line
     * @param symbol the symbol to check for
     * @return true if any row has all same symbol with the given symbol
     */
    private boolean checkRows(char symbol){
        for(int i=0;i<size;i++){
            boolean win=true;
            for(int j=0;j<size;j++){ //Check each symbol in the current row
                if(grid[i][j] !=symbol){
                    win=false;
                    break; //No need to check further if one symbol doesn't match
                }
            }

            if(win) return true; //Found a winning line
        }
        return false; //No rows found 
    }

    /**
     * Checks all cols for a winning line
     * @param symbol the symbol to check for
     * @return true if any column has all same symbol with the given symbol
     */
    private boolean checkCols(char symbol){
        for(int i=0;i<size;i++){
            boolean win=true;
            for(int j=0;j<size;j++){ //Check each symbol in the current col
                if(grid[j][i] !=symbol){
                    win=false;
                    break; //No need to check further if one symbol doesn't match
                }
            }

            if(win) return true; //Found a winning line
        }
        return false; //No cols found 
    }

    /**
     * Checks both diagonals for winning line
     * @param symbol the symbol to check for
     * @return true if either diagonal line has same symbol with the given symbol
     */
    private boolean checkDiag(char symbol){
        boolean d1Win=true;
        boolean d2Win=true;

        for(int i=0;i<size;i++){
            if(grid[i][i] !=symbol) d1Win=false; //Top-left to bottom-right
            if (grid[i][size-1-i]!=symbol) d2Win=false; //Top-right to bottom-left
        }
        return d1Win||d2Win; //true if either diagonal wins
    }
    

    /**
     * Checks if the board is completely filled - Draw
     * @return true if the board is full, false otherwise
     */
    public boolean isFull() {
        for (int i =0;i<size;i++){
            for (int j = 0; j < size;j++){
                if (grid[i][j] == ' '){
                    return false; //found an empty space
                }
            }
        }
        return true; //No empty spaces found
    }


    /**
     * Gets the current grid state
     * @return 2D char array representing the grid
     */
    public char[][]getGrid(){
        return this.grid;
    }

    /**
     * Gets the size of the board
     * @return dimension of the board
     */
    public int getSize(){
        return this.size;
    }

    /**
     * Clears a specific cell
     * @param row of that cell
     * @param col of that cell
     */
    public void clearCell(int row,int col){
        if(row >= 0 && row < size && col >= 0 && col < size){
            grid[row][col]=' ';
        }
    }

}
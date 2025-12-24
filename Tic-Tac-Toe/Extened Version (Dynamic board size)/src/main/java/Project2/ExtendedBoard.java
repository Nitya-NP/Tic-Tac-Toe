package Project2;

/**
 * Represents the extended game board for customizable Tic-Tac-Toe.
 * Manages NxN grid state and checks for custom win length conditions.
 * 
 * @author Nitya Patel
 * 
 */


public class ExtendedBoard extends Board{
    private int winLength;

    /**
     * Constructor to initialize the extended board
     * @param size dimensions of the board (NxN)
     * @param winLength the number of consecutive marks needed to win
     */
    public ExtendedBoard(int size, int winLength) {
        super(size); //Makes the board
        this.winLength=winLength;
    }

    /**
     * Checks if the given symbol has won the game - (player who has that symbol) 
     * @param symbol player's symbol to check for win
     * @return true if symbol has a win. 
     */
    @Override
    public boolean checkWin(char symbol){
        return checkCols(symbol) || checkDiag(symbol) || checkRows(symbol);
    }

    /**
     * Checks all rows for a winning line
     * @param symbol the symbol to check for
     * @return true if any row has all same symbol with the given symbol
     */
    private boolean checkRows(char symbol){
        char[][] grid = getGrid();
        int size = getSize();
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= size - winLength; j++) {
                boolean win = true;
                for (int k = 0; k < winLength; k++) {
                    if (grid[i][j + k] != symbol) {
                        win = false;
                        break;
                    }
                }
                if (win) return true;
            }
        }
        return false;
    } 

    /**
     * Checks all cols for a winning line
     * @param symbol to check for
     * @return true if any column has all same symbol with the given symbol
     */
    private boolean checkCols(char symbol){
        char[][] grid = getGrid();
        int size = getSize();
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= size - winLength; j++) {
                boolean win = true;
                for (int k = 0; k < winLength; k++) {
                    if (grid[j + k][i] != symbol) {
                        win = false;
                        break;
                    }
                }
                if (win) return true;
            }
        }
        return false;
    }

    /**
     * Checks both diagonals for winning line
     * @param symbol the symbol to check for
     * @return true if either diagonal line has same symbol with the given symbol
     */
    private boolean checkDiag(char symbol){
        return checkMainDiag(symbol) || checkAntiDiag(symbol);
    }

    /**
     * Checks main diagonals (top left to bottom right) for winning line
     * @param symbol
     * @return true if it has winning line, false otherwise
     */
    private boolean checkMainDiag(char symbol) {
        char[][] grid = getGrid();
        int size = getSize();
        
        for (int i = 0; i <= size - winLength; i++) {
            for (int j = 0; j <= size - winLength; j++) {
                boolean win = true;
                for (int k = 0; k < winLength; k++) {
                    if (grid[i + k][j + k] != symbol) {
                        win = false;
                        break;
                    }
                }
                if (win) return true;
            }
        }
        return false;
    }

    /**
     * Checks anti-diagonals(top-right to bottom-left) winning line
     * @param symbol
     * @return true if it has winning line, false otherwise
     */
    private boolean checkAntiDiag(char symbol) {
        char[][] grid = getGrid();
        int size = getSize();
        
        for (int i = 0; i <= size - winLength; i++) {
            for (int j = winLength - 1; j < size; j++) {
                boolean win = true;
                for (int k = 0; k < winLength; k++) {
                    if (grid[i + k][j - k] != symbol) {
                        win = false;
                        break;
                    }
                }
                if (win) return true;
            }
        }
        return false;
    }

    /**
     * Gets the win length required for this board
     * @return the number of marks needs to win
     */
    public int getWinLength(){
        return this.winLength;
    }

   

}
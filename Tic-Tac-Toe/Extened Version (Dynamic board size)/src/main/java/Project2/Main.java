package Project2;

import java.util.Scanner;

/**
 * Main class for Extended Tic-Tac-Toe game application.
 */
public class Main{
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        boolean restart=true;
        
        while (restart) {
            System.out.println("Welcome to Extended Tic-Tac-Toe!!!!");
            System.out.println("This version supports custom board sizes and win conditions!");
            ExtendedGameMenu menu= new ExtendedGameMenu(); //Create game manu and start the game
            ExtendedGame game = menu.startGame();
            game.play();
            restart= menu.askToRestart();
        }
        
        scan.close();
    }

}

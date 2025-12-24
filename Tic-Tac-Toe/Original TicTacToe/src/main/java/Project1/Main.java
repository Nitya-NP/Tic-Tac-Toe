package Project1;

import java.util.Scanner;

/**
 * Main class for Tic-Tac-Toe game application.
 */
public class Main{

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        boolean restart=true;
        
        do{
            System.out.println("Welcome to Tic-Tac-Toe!!!!");
            GameMenu menu= new GameMenu(scan); //Create game manu and start the game
            Game game = menu.startGame();
            game.play();

            restart= menu.askToRestart(); //Return true if user chose to restart
        } while(restart);
        
        scan.close();
    }
}

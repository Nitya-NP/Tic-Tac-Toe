package Project1;

import java.util.Scanner;

/**
 * Handles game configuration and menu system for Tic-Tac-Toe.
 * Allows users to select game mode, set up players before starting the game and 
 * after the game ask for restart.
 * 
 * @author Nitya Patel
 */


public class GameMenu{

    private Scanner scan;

    /**
     * Constructor to initialize the GameMenu
     * @param scan input from the player
     */
    public GameMenu(Scanner scan){
        this.scan= scan; //input
    }

    /**
     * Creates and configures a new game based on user selections
     * @return a configured Game instance ready to be started
     */
    public Game startGame(){
        System.out.println("Choose game mode: ");
        System.out.println("1. Human vs Human \n2. Human vs Computer \n3. Computer vs Computer \n4. Smart Computer vs Human \n5. Smart Computer vs Smart Computer" );

        int choice = getIntInput("Enter choice (1-5): ");
        Player player1,player2;

        //Configure players based on selected game model

        switch (choice) {
            case 1: // Human vs Human
                String name1= getNameInput("Enter name for Player1 X: ");
                String name2= getNameInput("Enter name for Player2 O: ");
                player1= new HumanPlayer('X', name1,scan);
                player2= new HumanPlayer('O', name2,scan);
                break;
            
            case 2: //Human vs Computer
                String name3= getNameInput("Enter name for Player X: ");
                player1= new HumanPlayer('X', name3,scan);
                player2= new ComputerPlayer('O', "Computer");
                break;
            
            case 3: //Computer vs Computer
                player1= new ComputerPlayer('X', "Computer 1");
                player2= new ComputerPlayer('O', "Computer 2");
                break;

            case 4: //Smart Computer vs Human - Bonus
                String name4= getNameInput("Enter name for Player X: ");
                player1= new HumanPlayer('X', name4,scan);
                player2= new SmartComputerPlayer('O', "Smart Computer");
                break;
            
            case 5: //Smart Computer vs Smart Computer - Bonus
                player1= new SmartComputerPlayer('X', "Smart Computer 1");
                player2= new SmartComputerPlayer('O', "Smart Computer 2");
                break;
            
            default: //Default names 
                player1= new HumanPlayer('X', "Player 1",scan);
                player2= new HumanPlayer('O', "Player 2",scan);
                break;
        }

        return new Game(player1,player2,3); //Standard 3x3 board
    }


    /**
     * Gets and validates int input from user within the range
     * @param prompt the message
     * @return validated int input between 1 to 5
     */
    private int getIntInput(String prompt){
        while (true){
            System.out.print(prompt);
            try{
                String str = scan.nextLine().trim();
                int input = Integer.parseInt(str);
                if(input>=1 && input<=5){
                    return input;
                }
                System.out.println("Please enter a number between "+1+" and "+5);
            }
            catch(Exception e){
                System.out.println("Invalid input! Please enter a number.");
            }
            
        }
    }

    /**
     * Gets and validates name string from user
     * @param prompt the message
     * @return validated string name with out spaces
     */
    private String getNameInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String name = scan.nextLine().trim();

            if(!name.isEmpty()) return name;
            
            System.out.println("Invalid input! Name cannot be empty. ");
        }
    }

    /**
     * Prompts user to play another game
     * Handles user input for restart decision
     */
    public boolean askToRestart(){

        while(true){
            System.out.println("\nWould you like to play again? (y/n)");
            String input = scan.nextLine().trim().toLowerCase();

            if (input.equals("y")){
                return true;
            } 
            else if (input.equals("n")){
                System.out.println("Thank you for Playing Tic-Tac-Toe! See you next time :)");
                return false;
            } 
            else {
                System.out.println("Invalid input. Please enter 'y' or 'n'.");
            }
        }
    }

}
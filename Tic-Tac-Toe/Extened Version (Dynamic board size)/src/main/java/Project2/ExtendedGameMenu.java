package Project2;

import java.util.Scanner;

/**
 * Handles game configuration and menu system for Extended Tic-Tac-Toe.
 * Allows users to select board size, win length, and game mode before starting.
 * 
 * @author Nitya Patel
 * 
 */


public class ExtendedGameMenu{

    private Scanner scan;

    /**
     * Constructor to initialize the ExtendedGameMenu
     */
    public ExtendedGameMenu(){
        this.scan=new Scanner(System.in);
    }

    /**
     * Creates and configures a new extended game based on user selections
     * @return a ExtendedGame instance ready to be started
     */
    public ExtendedGame startGame(){
        int size= getIntInput("Enter board size (3-20): ",3,20);
        int winLength= getIntInput("Enter winning line length (3-"+size+"): ", 3, size);
        
        System.out.println("Choose game mode: ");
        System.out.println("1. Human vs Human \n2. Human vs Computer \n3. Computer vs Computer \n4. Smart Computer vs Human \n5. Smart Computer vs Smart Computer");

        int choice = getIntInput("Enter choice (1-5): ",1,5);
        Player player1,player2;

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

        return new ExtendedGame(player1,player2,size,winLength);
    }

    /**
     * Gets and validates int input from user within specified range
     * @param prompt the message
     * @param min minimum acceptable value
     * @param max maximum acceptable value
     * @return validated int input between min and maax
     */
    private int getIntInput(String prompt,int min,int max){
        while (true){
            System.out.print(prompt);

            try{
                String str = scan.nextLine().trim();
                int input = Integer.parseInt(str);
                if(input>=min && input<=max){
                    return input;
                }
                System.out.println("Please enter a number between "+min+" and "+max);
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
     * @param scan - user input
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
                System.out.println("Invalid input. Please enter 'y/n'.");
            }
        }
    }

}
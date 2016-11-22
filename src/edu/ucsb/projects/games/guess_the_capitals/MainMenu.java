package edu.ucsb.cs56.projects.games.guess_the_capitals;

/**
 * MainMenu object that player sees when game first begins
 *
 * @author Sean Shelton, Armin Mahini
 * @version UCSB CS56, F16
 */
public class MainMenu extends Menu{
    
    /** Overridden version simply prints selections for the user to choose
     *  from when the game first begins
     *  @param menuData contains information such as the number of possible choices, 
     *  question number and Territory and Capital objects
     */
    public void printMenu(MenuData menuData){
		System.out.println("\nWelcome to the capitals quiz game! \nWhat would you like to do?");
		System.out.println("\n0. Play US State Capitals Game");
		System.out.println("1. Play North American Capitals Game");
		System.out.println("2. Play South American Capitals Game");		
		System.out.println("3. Play European Capitals Game");
		System.out.println("4. Play Asian Capitals Game");
		System.out.println("5. Play African Capitals Game");
		System.out.println("6. Play Australian Capitals Game");
		System.out.println("7. Play World Capitals Game");
		System.out.println("8. Play a game with World and State Capitals");
		System.out.println("\nPlease select a number: \n");
    }

}

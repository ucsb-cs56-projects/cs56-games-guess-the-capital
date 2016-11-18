/**
 * FinalMenu object that player sees when game finishes
 *
 * @author Sean Shelton, Armin Mahini
 * @version UCSB CS56, F16
 */
package edu.ucsb.cs56.projects.games.guess_the_capitals;

import java.io.*;

public class FinalMenu extends Menu{

    /** Prints last menu the user sees once the game is over. Displays the users score and gives
     *  them the option to play again or end the session
     */
    public void printMenu(MenuData menuData){
		assert (menuData != null);
		System.out.println("\n\n\n");
		System.out.println("Your Total Score: " + menuData.numCorrect + "/" + menuData.numQuestions);
		System.out.println("\n\n\n");
		System.out.println("Enter 1 to play again (entering anything else quits the game)");
    }

}

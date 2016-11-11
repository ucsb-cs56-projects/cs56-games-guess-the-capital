/**
 * FinalMenu object that player sees when game finishes
 *
 * @author Sean Shelton, Armin Mahini
 * @version UCSB CS56, F16
 */
package edu.ucsb.cs56.projects.games.guess_the_capitals;

import java.io.*;

public class FinalMenu extends Menu{

    public void printMenu(MenuData menuData){
		System.out.println("\n\n\n");
		System.out.println("Your Total Score: " + menuData.numCorrect + "/" + menuData.numQuestions);
		System.out.println("\n\n\n");
		System.out.println("Enter 1 to play again (entering anything else quits the game)");
    }

}
